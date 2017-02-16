package com.yoyohr.client.resource.saiku.bean;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuMember extends AbstractSaikuObject {

    private String caption;
    private String dimensionUniqueName;
    private String description;
    private String levelUniqueName;
    private String hierarchyUniqueName;
    private Boolean calculated;

    SaikuMember() {
    }

    public SaikuMember(
            String name,
            String uniqueName,
            String caption,
            String description,
            String dimensionUniqueName,
            String hierarchyUniqueName,
            String levelUniqueName,
            boolean calculated) {
        super( uniqueName, name );
        this.caption = caption;
        this.description = description;
        this.dimensionUniqueName = dimensionUniqueName;
        this.levelUniqueName = levelUniqueName;
        this.hierarchyUniqueName = hierarchyUniqueName;
        this.calculated = calculated;
    }

    public SaikuMember(
            String name,
            String uniqueName,
            String caption,
            String description,
            String dimensionUniqueName,
            String hierarchyUniqueName,
            String levelUniqueName) {
        super( uniqueName, name );
        this.caption = caption;
        this.description = description;
        this.dimensionUniqueName = dimensionUniqueName;
        this.levelUniqueName = levelUniqueName;
        this.hierarchyUniqueName = hierarchyUniqueName;
        this.calculated = false;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public String getLevelUniqueName() {
        return levelUniqueName;
    }

    public String getDimensionUniqueName() {
        return dimensionUniqueName;
    }

    public String getHierarchyUniqueName() {
        return hierarchyUniqueName;
    }

    public Boolean isCalculated() {
        return calculated;
    }

    public void setCalculated(Boolean calculated) {
        this.calculated = calculated;
    }
}
