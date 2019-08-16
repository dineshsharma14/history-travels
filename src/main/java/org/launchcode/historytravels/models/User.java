package org.launchcode.historytravels.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    @Size(min = 3, max = 15)
    private String userName;

    @NotNull
    @Size(min = 10, max = 50)
    private String email;

    @NotNull
    @Size(min = 5, max = 100)
    private String password;

    private int userId;
    private static int nextUserId = 1;

    public User (String userName, String email, String password) {
        this();
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(){
        userId = nextUserId;
        nextUserId++;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
