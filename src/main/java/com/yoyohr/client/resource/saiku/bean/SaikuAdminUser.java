package com.yoyohr.client.resource.saiku.bean;

/**
 * Created by Administrator on 2017/5/19.
 */
public class SaikuAdminUser {
    private String username;
    private String email;
    private String password;
    private String[] roles;
    private int id;

    public SaikuAdminUser() {
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
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
