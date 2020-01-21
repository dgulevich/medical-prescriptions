package com.it.app.dto.response;

/**
 * The type Token response dto.
 */
public class TokenResponseDto {

    /**
     * The Type.
     */
    public String type = "Bearer";

    /**
     * The Token.
     */
    public String token;

    /**
     * Instantiates a new Token response dto.
     *
     * @param token the token
     */
    public TokenResponseDto(String token) {
        this.token = token;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
