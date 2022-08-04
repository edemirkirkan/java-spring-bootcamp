package com.edemirkirkan.homework3.veh.dto;

import lombok.Data;

@Data
public class VehVehicleRequestDto {
    private String brand;
    private String model;
    private String plate;
    private Long customerId;
}
