package com.it.app.component;

import org.springframework.stereotype.Component;

@Component
public class Validation {

    public void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }

}
