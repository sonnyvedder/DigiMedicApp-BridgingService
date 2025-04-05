package com.digitekno.digimedic.service;

import com.digitekno.digimedic.dto.RegistrationRequest;
import com.digitekno.digimedic.dto.RegistrationResponse;
import com.digitekno.digimedic.model.ClientRegistration;
import com.digitekno.digimedic.repository.ClientRegistrationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RegistrationService {

    private final ClientRegistrationRepository registrationRepository;

    public RegistrationService(ClientRegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Transactional
    public RegistrationResponse registerClient(RegistrationRequest request) {
        if (registrationRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        ClientRegistration registration = new ClientRegistration();
        registration.setOrganizationName(request.getOrganizationName());
        registration.setEmail(request.getEmail());
        registration.setContactPerson(request.getContactPerson());
        registration.setPhoneNumber(request.getPhoneNumber());
        registration.setClientId(generateClientId());
        registration.setSecretKey(generateSecretKey());
        registration.setActive(false);
        registration.setCreatedAt(LocalDateTime.now());
        
        registrationRepository.save(registration);
        
        return RegistrationResponse.builder()
                .clientId(registration.getClientId())
                .secretKey(registration.getSecretKey())
                .status("PENDING_VERIFICATION")
                .message("Please check your email to verify your account")
                .build();
    }

    private String generateClientId() {
        return "DGM-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private String generateSecretKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}