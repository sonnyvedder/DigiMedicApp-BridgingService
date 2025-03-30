package com.digitekno.digimedic.dto;

import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class RegistrationResponse {
    private String clientId;
    private String secretKey;
    private String message;
    private String status;
}