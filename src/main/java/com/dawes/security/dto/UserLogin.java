package com.dawes.security.dto;


import jakarta.validation.constraints.NotBlank;

public class UserLogin {
    @NotBlank
    private String userEmail;
    @NotBlank
    private String contrasenia;

    public String getUserEmail() {
        return userEmail;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
