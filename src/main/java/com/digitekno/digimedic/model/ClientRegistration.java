package com.digitekno.digimedic.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "client_registrations")
public class ClientRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false)
    private String organizationName;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String contactPerson;
    
    private String phoneNumber;
    
    @Column(nullable = false, unique = true)
    private String clientId;
    
    @Column(nullable = false)
    private String secretKey;
    
    private boolean isActive;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}