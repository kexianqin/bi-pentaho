package com.yoyohr.client.resource.pentaho.query;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Measure {
    private String caption;

    private String memberType;

    private String name;

    private String qualifiedName;

    private String type;

    public Measure() {
    }

    public void setCaption(String caption){
        this.caption = caption;
    }
    public String getCaption(){
        return this.caption;
    }
    public void setMemberType(String memberType){
        this.memberType = memberType;
    }
    public String getMemberType(){
        return this.memberType;
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
        return "Measure{" +
            "caption='" + caption + '\'' +
            ", memberType='" + memberType + '\'' +
            ", name='" + name + '\'' +
            ", qualifiedName='" + qualifiedName + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}
