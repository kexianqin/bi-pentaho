package com.yoyohr.client.resource.pentaho.query;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Dimension {
    private String caption;

    private List<Hierarchie> hierarchies ;

    private String name;

    private String type;

    public Dimension() {
    }

    public void setCaption(String caption){
        this.caption = caption;
    }
    public String getCaption(){
        return this.caption;
    }
    public void setHierarchies(List<Hierarchie> hierarchies){
        this.hierarchies = hierarchies;
    }
    public List<Hierarchie> getHierarchies(){
        return this.hierarchies;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    @Override
    public String toString() {
        return "Dimension{" +
            "caption='" + caption + '\'' +
            ", hierarchies=" + hierarchies +
            ", name='" + name + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}
