package com.digitekno.digimedic.controller;

import com.digitekno.digimedic.service.RegistrationService;
import com.digitekno.digimedic.dto.RegistrationRequest;
import com.digitekno.digimedic.dto.RegistrationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/registration")
@Tag(name = "Registration", description = "Client Registration APIs")
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    @Operation(summary = "Register new client")
    public ResponseEntity<RegistrationResponse> registerClient(
            @Valid @RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(registrationService.registerClient(request));
    }

    @GetMapping("/verify/{token}")
    @Operation(summary = "Verify email and activate account")
    public ResponseEntity<String> verifyEmail(@PathVariable String token) {
        return ResponseEntity.ok(registrationService.verifyEmail(token));
    }

    @PostMapping("/regenerate")
    @Operation(summary = "Regenerate API credentials")
    public ResponseEntity<RegistrationResponse> regenerateCredentials(
            @RequestParam String clientId) {
        return ResponseEntity.ok(registrationService.regenerateCredentials(clientId));
    }
}