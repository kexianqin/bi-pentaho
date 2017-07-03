package com.yoyohr.client.resource.pentaho.query;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public class Hierarchie {
    private String caption;

    private String defaultMember;

    private String defaultMemberQualifiedName;

    private List<Level> levels ;

    private String name;

    private String qualifiedName;

    private String type;

    public Hierarchie() {
    }

    public void setCaption(String caption){
        this.caption = caption;
    }
    public String getCaption(){
        return this.caption;
    }
    public void setDefaultMember(String defaultMember){
        this.defaultMember = defaultMember;
    }
    public String getDefaultMember(){
        return this.defaultMember;
    }
    public void setDefaultMemberQualifiedName(String defaultMemberQualifiedName){
        this.defaultMemberQualifiedName = defaultMemberQualifiedName;
    }
    public String getDefaultMemberQualifiedName(){
        return this.defaultMemberQualifiedName;
    }
    public void setLevels(List<Level> levels){
        this.levels = levels;
    }
    public List<Level> getLevels(){
        return this.levels;
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
        return "Hierarchie{" +
            "caption='" + caption + '\'' +
            ", defaultMember='" + defaultMember + '\'' +
            ", defaultMemberQualifiedName='" + defaultMemberQualifiedName + '\'' +
            ", levels=" + levels +
            ", name='" + name + '\'' +
            ", qualifiedName='" + qualifiedName + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}

