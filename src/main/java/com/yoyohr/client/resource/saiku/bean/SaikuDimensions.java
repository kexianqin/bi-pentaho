package com.yoyohr.client.resource.saiku.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 *
 * @author kxq kexianqin@yoyohr.com
 */
public class SaikuDimensions extends AbstractSaikuObject {
    private String caption;
    private String description;
    private boolean visible;
    private List<SaikuHierarchies> hierarchies;

    public SaikuDimensions() {
    }

    public SaikuDimensions(String uniqueName, String name, String description, List<SaikuHierarchies> hierarchies,String caption) {
          this (uniqueName,name,description,hierarchies,caption,true);
    }

    public SaikuDimensions(String uniqueName, String name, String description, List<SaikuHierarchies> hierarchies,String caption,boolean visible) {
        super(uniqueName, name);
        this.description = description;
        this.caption=caption;
        this.hierarchies=hierarchies;
        this.visible=visible;
    }

    public String getCaption() {return caption;}
    public String getDescription() {return description;}
    public List<SaikuHierarchies> getHierarchies() {return hierarchies;}
    public boolean isVisible() {return visible;}
}

