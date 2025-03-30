package com.digitekno.digimedic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "satusehat")
@Data
public class SatusehatConfig {
    private String baseUrl;
    private String clientId;
    private String clientSecret;
    private String organizationId;
    private String authUrl;
}