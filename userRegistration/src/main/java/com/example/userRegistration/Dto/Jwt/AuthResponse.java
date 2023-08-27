package com.example.userRegistration.Dto.Jwt;

public class AuthResponse {

    private String jwtToken;
    private String errorMessage;

    public AuthResponse() {
    }

    public AuthResponse(String jwtToken, String errorMessage) {
        this.jwtToken = jwtToken;
        this.errorMessage = errorMessage;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
