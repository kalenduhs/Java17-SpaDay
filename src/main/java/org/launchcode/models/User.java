package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank
    @Size(min = 5, max = 15, message = "Please enter a username between 5 and 15 characters")
    private String username;
    @Email
    private String email;
    @NotBlank
    @Size(min = 6, message = "Please enter a password with at least 6 characters")
    private String password;
    @NotBlank
    @Size(min = 6, message = "Please enter a password with at least 6 characters")
    @NotNull(message = "Please enter matching passwords")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    private void checkPassword() {
        if (!(getVerifyPassword().equals(getPassword()))) {
            setVerifyPassword(null);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }


}

