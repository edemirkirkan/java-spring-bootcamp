package com.edemirkirkan.homework3.sec.auth.dto;

import lombok.Data;

@Data
public class AuthenticationLoginRequestDto {
    private String username;
    private String password;
}
