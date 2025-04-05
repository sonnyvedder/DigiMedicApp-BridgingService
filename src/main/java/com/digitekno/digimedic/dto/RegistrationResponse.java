package com.digitekno.digimedic.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationResponse {
    private String clientId;
    private String secretKey;
    private String status;
    private String message;
}