package com.it.app.component;

import org.springframework.stereotype.Component;

/**
 * The type Validation.
 */
@Component
public class Validation {

    /**
     * Validate.
     *
     * @param expression   the expression
     * @param errorMessage the error message
     */
    public void validate(boolean expression, String errorMessage) {
        if (expression) {
            throw new RuntimeException(errorMessage);
        }
    }

}
