package com.digitekno.digimedic.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic transactionLogTopic() {
        return TopicBuilder.name("transaction-logs")
                          .partitions(10)
                          .replicas(3)
                          .build();
    }

    @Bean
    public NewTopic apiRequestsTopic() {
        return TopicBuilder.name("api-requests")
                          .partitions(20)
                          .replicas(3)
                          .build();
    }
}