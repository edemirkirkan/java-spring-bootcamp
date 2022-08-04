package com.edemirkirkan.homework3.cus.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CusCustomerUpdateRequestDto {
    private String password;
    private String newPassword;
    private String newPasswordAgain;
}
