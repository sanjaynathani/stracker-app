package com.glassera.stracker.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String displayName;
    private String token;

    public LoggedInUser(String displayName, String token) {
        this.displayName = displayName;
        this.token = token;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getToken() { return token; }
}