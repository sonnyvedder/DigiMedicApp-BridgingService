package com.digitekno.digimedic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "digimedic.api")
@Data
public class ApiKeyConfig {
    private String clientId;
    private String secretKey;
    private Long tokenExpirationMs;
}