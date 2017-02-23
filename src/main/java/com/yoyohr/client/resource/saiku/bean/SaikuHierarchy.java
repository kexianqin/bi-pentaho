package com.yoyohr.client.resource.saiku.bean;

import java.util.List;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuHierarchy extends AbstractSaikuObject {

    private String caption;
    private String dimensionUniqueName;
    private List<SaikuLevel> levels;
    private List<SaikuMember> rootMembers;
    private String description;
    private boolean visible;

    public SaikuHierarchy() {
        super( null, null );
    }

    public SaikuHierarchy( String name, String uniqueName, String caption, String description, String dimensionUniqueName,
                           boolean visible, List<SaikuLevel> levels, List<SaikuMember> rootMembers ) {
        super( uniqueName, name );
        this.caption = caption;
        this.dimensionUniqueName = dimensionUniqueName;
        this.levels = levels;
        this.rootMembers = rootMembers;
        this.description = description;
        this.visible = visible;
    }

    public String getCaption() {
        return caption;
    }

    public String getDimensionUniqueName() {
        return dimensionUniqueName;
    }

    public List<SaikuLevel> getLevels() {
        return levels;
    }

    public List<SaikuMember> getRootMembers() {
        return this.rootMembers;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    public boolean isVisible() {
        return visible;
    }
}
