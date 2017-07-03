package com.yoyohr.client.resource.pentaho.query;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Level {
    private String caption;

    private int depth;

    private String name;

    private String qualifiedName;

    private String type;

    public Level() {
    }

    public void setCaption(String caption){
        this.caption = caption;
    }
    public String getCaption(){
        return this.caption;
    }
    public void setDepth(int depth){
        this.depth = depth;
    }
    public int getDepth(){
        return this.depth;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setQualifiedName(String qualifiedName){
        this.qualifiedName = qualifiedName;
    }
    public String getQualifiedName(){
        return this.qualifiedName;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    @Override
    public String toString() {
        return "Level{" +
            "caption='" + caption + '\'' +
            ", depth=" + depth +
            ", name='" + name + '\'' +
            ", qualifiedName='" + qualifiedName + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}
