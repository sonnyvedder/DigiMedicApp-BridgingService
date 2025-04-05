# Build stage
FROM maven:3.9.5-eclipse-temurin-17-focal AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

# Add wait-for-it script to handle service startup order
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# Add healthcheck
HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:8080/actuator/health || exit 1

EXPOSE 8080
ENTRYPOINT ["/wait-for-it.sh", "postgres:5432", "--", \
            "/wait-for-it.sh", "kafka:9092", "--", \
            "/wait-for-it.sh", "redis:6379", "--", \
            "/wait-for-it.sh", "elasticsearch:9200", "--", \
            "java", "-jar", "app.jar"]