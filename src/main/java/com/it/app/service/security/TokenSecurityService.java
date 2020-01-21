package com.it.app.service.security;

import org.springframework.security.core.Authentication;

/**
 * The interface Token security service.
 */
public interface TokenSecurityService {

    /**
     * Generate string.
     *
     * @param authentication the authentication
     * @return the string
     */
    String generate(Authentication authentication);

    /**
     * Refresh string.
     *
     * @param token the token
     * @return the string
     */
    String refresh(String token);

    /**
     * Extract username string.
     *
     * @param token the token
     * @return the string
     */
    String extractUsername(String token);

    /**
     * Validate boolean.
     *
     * @param authToken the auth token
     * @return the boolean
     */
    boolean validate(String authToken);
}
