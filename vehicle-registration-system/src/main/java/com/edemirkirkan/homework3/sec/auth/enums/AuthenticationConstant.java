package com.edemirkirkan.homework3.sec.auth.enums;

public enum AuthenticationConstant {

    BEARER("Bearer ")
    ;

    private final String constant;

    AuthenticationConstant(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }

    @Override
    public String toString() {
        return constant;
    }
}
