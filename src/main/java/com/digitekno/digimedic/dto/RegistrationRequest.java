package com.digitekno.digimedic.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegistrationRequest {
    @NotBlank(message = "Organization name is required")
    private String organizationName;
    
    @Email(message = "Valid email is required")
    @NotBlank(message = "Email is required")
    private String email;
    
    @NotBlank(message = "Contact person name is required")
    private String contactPerson;
    
    private String phoneNumber;
}