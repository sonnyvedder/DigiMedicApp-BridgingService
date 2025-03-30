package com.digitekno.digimedic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
    info = @Info(
        title = "Healthcare Integration API",
        version = "1.0",
        description = "Bridging service for BPJS and SATUSEHAT integration"
    ),
    servers = {
        @Server(
            url = "http://localhost:8080",
            description = "Development server"
        )
    }
)
public class DigimedicApplication {
    public static void main(String[] args) {
        SpringApplication.run(DigimedicApplication.class, args);
    }
}
