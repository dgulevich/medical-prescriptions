package com.it.app.controller;

import com.it.app.dto.request.UserRegistrationRequestDto;
import com.it.app.dto.response.TokenResponseDto;
import com.it.app.model.Role;
import com.it.app.model.User;
import com.it.app.service.RoleService;
import com.it.app.service.UserService;
import com.it.app.service.security.TokenSecurityService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Authentication controller.
 */
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final UserService userService;

    private final RoleService roleService;

    private final TokenSecurityService tokenSecurityService;

    private final PasswordEncoder encoder;

    private final AuthenticationManager authenticationManager;

    /**
     * Instantiates a new Authentication controller.
     *
     * @param userService           the user service
     * @param roleService           the role service
     * @param tokenSecurityService  the token security service
     * @param encoder               the encoder
     * @param authenticationManager the authentication manager
     */
    public AuthenticationController(UserService userService, RoleService roleService, TokenSecurityService tokenSecurityService, PasswordEncoder encoder, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.roleService = roleService;
        this.tokenSecurityService = tokenSecurityService;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
    }

    /**
     * Authenticate user token response dto.
     *
     * @param requestDto the request dto
     * @return the token response dto
     */
    @PostMapping("/signIn")
    public TokenResponseDto authenticateUser(@RequestBody UserRegistrationRequestDto requestDto) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new TokenResponseDto(tokenSecurityService.generate(authentication));
    }

    /**
     * Refresh token token response dto.
     *
     * @param token the token
     * @return the token response dto
     */
    @PostMapping("/refresh")
    public TokenResponseDto refreshToken(@RequestBody String token) {
        return new TokenResponseDto(tokenSecurityService.refresh(token));
    }

    /**
     * Register user user.
     *
     * @param userRegistrationRequestDto the user registration request dto
     * @return the user
     */
    @PostMapping("/signUp")
    public User registerUser(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {
        final User user = new User();
        user.setName(userRegistrationRequestDto.getUsername());
        user.setPassword(userRegistrationRequestDto.getPassword());
        final Set<Role> roles = userRegistrationRequestDto.getRoles().stream()
                .map(roleService::findByName)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
        user.setRoles(roles);
        return userService.save(user);
    }
}
