package com.edemirkirkan.homework3.gen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException{

    public ItemNotFoundException(BaseErrorMessage errorMessage) {
        super(errorMessage);
    }
}
