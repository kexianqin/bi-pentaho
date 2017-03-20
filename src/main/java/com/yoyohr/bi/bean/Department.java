package com.yoyohr.bi.bean;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2017/2/20.
 */
public class Department {
    private List<UserT> users;

//    private String Dname;

    HashMap<String,String> dname;


    public Department(){

    };


//        public String getDname() {
//        return Dname;
//    }

    public List<UserT> getUsers() {
        return users;
    }

    public void setUsers(List<UserT> users) {
        this.users = users;
    }


    public HashMap<String, String> getDname() {
        return dname;
    }

    public void setDname(HashMap<String, String> dname) {
        this.dname = dname;
    }
    //    public void setDname(String dname) {
//        Dname = dname;
//    }



        public String toString(){ return "The class name is"+dname+"The users are"+users;
    }

}
