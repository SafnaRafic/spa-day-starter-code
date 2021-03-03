package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    @NotEmpty(message = "Username cannot be empty")
    @Size(min = 5, max=50,message = "Username needs to be between 5 and 50 characters")
    private String username;

    @Email
    @NotNull(message = "Should not be null")
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, message = "Password needs to be longer than 6 characters")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
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
        this.checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        this.checkPassword();
    }

    private void checkPassword(){
        if(this.password != null && this.verifyPassword != null && !this.password.equals(this.verifyPassword)){
            this.verifyPassword = null;
        }
    }

}
