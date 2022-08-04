package com.edemirkirkan.homework3.cus.enums;

import com.edemirkirkan.homework3.gen.exceptions.BaseErrorMessage;

public enum CusErrorMessage implements BaseErrorMessage {

    CUSTOMER_DOES_NOT_EXIST("Customer does not exist!"),
    PASSWORDS_NOT_MATCHING("New passwords are not matching!"),
    DUPLICATE_USERNAME("Username already exists!"),
    PASSWORD_LENGTH("Passwords should have a minimum of eight characters!"),
    WRONG_PASSWORD("Old password is not matching with the current user!")
    ;

    private final String message;

    CusErrorMessage(String message) {
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
