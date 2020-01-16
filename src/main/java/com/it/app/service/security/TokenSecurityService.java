package com.it.app.service.security;

import org.springframework.security.core.Authentication;

public interface TokenSecurityService {

    String generate(Authentication authentication);

    String refresh(String token);

    String extractUsername(String token);

    boolean validate(String authToken);
}
