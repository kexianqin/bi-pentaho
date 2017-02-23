package com.yoyohr.bi.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/20.
 */
public class Department {
    private List<UserT> users;
    private String Dname;

    public Department(){};

    public String getDname() {
        return Dname;
    }

    public List<UserT> getUsers() {

        return users;
    }

    public void setUsers(List<UserT> users) {
        this.users = users;
    }

    public void setDname(String dname) {
        Dname = dname;
    }

    public String toString(){
        return "The class name is"+Dname+"The users are"+users;
    }
}
