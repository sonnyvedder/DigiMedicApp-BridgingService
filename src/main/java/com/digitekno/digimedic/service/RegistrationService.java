package com.digitekno.digimedic.service;

import com.digitekno.digimedic.dto.RegistrationRequest;
import com.digitekno.digimedic.dto.RegistrationResponse;
import com.digitekno.digimedic.model.ClientRegistration;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class RegistrationService {
    
    public RegistrationResponse registerClient(RegistrationRequest request) {
        // Generate unique client credentials
        String clientId = generateClientId();
        String secretKey = generateSecretKey();
        
        // Save to database and send verification email
        
        return RegistrationResponse.builder()
            .clientId(clientId)
            .secretKey(secretKey)
            .status("PENDING_VERIFICATION")
            .message("Please check your email to verify your account")
            .build();
    }
    
    public String verifyEmail(String token) {
        // Verify token and activate account
        return "Email verified successfully";
    }
    
    public RegistrationResponse regenerateCredentials(String clientId) {
        // Regenerate credentials for existing client
        String newSecretKey = generateSecretKey();
        
        return RegistrationResponse.builder()
            .clientId(clientId)
            .secretKey(newSecretKey)
            .status("UPDATED")
            .message("New credentials generated successfully")
            .build();
    }
    
    private String generateClientId() {
        return "DGM-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    
    private String generateSecretKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}