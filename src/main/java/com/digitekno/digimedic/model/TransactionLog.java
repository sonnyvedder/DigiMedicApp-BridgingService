package com.digitekno.digimedic.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "transaction_logs")
public class TransactionLog extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false)
    private String clientId;
    
    @Column(nullable = false)
    private String serviceType; // BPJS or SATUSEHAT
    
    @Column(nullable = false)
    private String endpoint;
    
    @Column(length = 4000)
    private String request;
    
    @Column(length = 4000)
    private String response;
    
    private String responseCode;
    
    private Long responseTime;
    
    private String status;
    
    @Column(length = 1000)
    private String errorMessage;
}