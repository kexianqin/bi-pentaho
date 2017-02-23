package com.yoyohr.bi.bean;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class UserT {

    private long id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {

        this.id = id;
    }

    public UserT() {
    }
    public UserT(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
     public String toString() {
        return "User{id:"+id+","+"name:"+name+"}";
     }
}