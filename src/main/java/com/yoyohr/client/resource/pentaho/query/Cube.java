package com.yoyohr.client.resource.pentaho.query;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Cube {
    private String id;

    private String name;

    public Cube() {
    }

    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Cube{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
