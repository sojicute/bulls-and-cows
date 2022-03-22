package com.example.bullsandcows.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto {

    @NotEmpty(message = "User's name cannot be empty.")
    @Size(min = 5, max = 250)
    private String username;

    @NotEmpty(message = "Password cannot be empty.")
    @Size(min = 8, max = 250)
    private String password;

    @NotEmpty(message = "Password cannot be empty.")
    @Size(min = 8, max = 250)
    private String matchingPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
