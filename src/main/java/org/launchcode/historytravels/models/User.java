package org.launchcode.historytravels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String username;

    @NotNull
    @Size(min = 5, max = 100)
    private String password;

    @NotNull
    @Size(min = 5, max = 100,
            message = "Verify password must be same as password")
    private String verify;

    public User (String username, String password,
                 String verify) {
        this.username = username;
        this.password = password;
        this.verify = verify;
    }

    public User(){
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }
}
