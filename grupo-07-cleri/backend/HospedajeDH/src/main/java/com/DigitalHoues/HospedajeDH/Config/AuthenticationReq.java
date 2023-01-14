package com.DigitalHoues.HospedajeDH.Config;

import java.io.Serializable;

public class AuthenticationReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String user;

    private String password;

    public AuthenticationReq(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String username) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
