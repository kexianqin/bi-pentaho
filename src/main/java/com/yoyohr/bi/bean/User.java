package com.yoyohr.bi.bean;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class User {

    private long id;
    private String name;

    public User() {}

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
