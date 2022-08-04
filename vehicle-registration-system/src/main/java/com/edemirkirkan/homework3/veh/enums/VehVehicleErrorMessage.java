package com.edemirkirkan.homework3.veh.enums;

import com.edemirkirkan.homework3.gen.exceptions.BaseErrorMessage;

public enum VehVehicleErrorMessage implements BaseErrorMessage {

    VEHICLE_DOES_NOT_EXIST("Vehicle does not exist!"),
    VEHICLE_CUSTOMER_DOES_NOT_EXIST("Customer not found!"),
    DIFFERENT_CUSTOMER_ACCESS("Access denied! User can only modify his/her vehicles"),
    ;

    private final String message;

    VehVehicleErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
