package com.digitekno.digimedic.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "response_cache")
public class ResponseCache extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    
    @Column(nullable = false)
    private String cacheKey;
    
    @Column(length = 4000)
    private String responseData;
    
    private LocalDateTime expiryTime;
    
    @Column(nullable = false)
    private String serviceType;
}