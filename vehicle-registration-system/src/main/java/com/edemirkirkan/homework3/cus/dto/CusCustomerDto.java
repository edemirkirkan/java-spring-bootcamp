package com.edemirkirkan.homework3.cus.dto;

import lombok.Data;

@Data
public class CusCustomerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
}
