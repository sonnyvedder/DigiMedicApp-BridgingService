package com.digitekno.digimedic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class ClientRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String organizationName;
    private String email;
    private String clientId;
    private String secretKey;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
    private boolean active;
}