package com.yoyohr.client.resource.saiku.bean;

import java.util.List;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuDimension extends AbstractSaikuObject {

    private String caption;
    private String description;
    private boolean visible;
    private List<SaikuHierarchy> hierarchies;


    public SaikuDimension() {
        super( null, null );
    }

    public SaikuDimension( String name, String uniqueName, String caption, String description, boolean visible,
                           List<SaikuHierarchy> hierarchies ) {
        super( uniqueName, name );
        this.caption = caption;
        this.description = description;
        this.visible = visible;
        this.hierarchies = hierarchies;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVisible() {
        return visible;
    }

    public List<SaikuHierarchy> getHierarchies() {
        return hierarchies;
    }

}
