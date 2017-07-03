package com.yoyohr.client.resource.pentaho.query;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Catalog {

    @JsonProperty("cubes")
    private List<Cube> cubes ;

    private String jndi;

    private String name;

    private String schema;

    public Catalog() {
    }

    public void setCubes(List<Cube> cubes){
        this.cubes = cubes;
    }
    public List<Cube> getCubes(){
        return this.cubes;
    }
    public void setJndi(String jndi){
        this.jndi = jndi;
    }
    public String getJndi(){
        return this.jndi;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSchema(String schema){
        this.schema = schema;
    }
    public String getSchema(){
        return this.schema;
    }

    @Override
    public String toString() {
        return "Catalog{" +
            "cubes=" + cubes +
            ", jndi='" + jndi + '\'' +
            ", name='" + name + '\'' +
            ", schema='" + schema + '\'' +
            '}';
    }
}
