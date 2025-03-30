package com.digitekno.digimedic.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "bpjs")
@Data
public class BpjsConfig {
    private String baseUrl;
    private String consId;
    private String secretKey;
    private String userKey;
    private String serviceType;
}