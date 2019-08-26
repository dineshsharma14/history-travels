package org.launchcode.historytravels.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginUser {

    @NotNull
    @Size(min = 3, max = 15, message="Username field can't be empty!")
    private String name;

    @NotNull
    @Size(min = 1, message = "Password field can't be empty!")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
