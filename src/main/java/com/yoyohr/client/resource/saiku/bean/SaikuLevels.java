package com.yoyohr.client.resource.saiku.bean;


/**
 * Created by Administrator on 2017/2/23.
 */

public class SaikuLevels extends AbstractSaikuObject {
    private String caption;
    private String annotations;
    private String levelType;
    private String hierarchyUniqueName;
    private String dimensionUniqueName;
    private boolean visible;
    private String description;

    public SaikuLevels() {
    }

    public SaikuLevels(String annotations, String caption, String levelType, String hierarchyUniqueName, String dimensionUniqueName, boolean visible, String description
            , String uniqueName, String name) {
        super(uniqueName, name);
        this.annotations = annotations;
        this.caption = caption;
        this.description = description;
        this.dimensionUniqueName = dimensionUniqueName;
        this.hierarchyUniqueName = hierarchyUniqueName;
        this.levelType = levelType;
        this.visible = visible;
    }

    public String getAnnotations() {
        return annotations;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public String getDimensionUniqueName() {
        return dimensionUniqueName;
    }

    public String getHierarchyUniqueName() {
        return hierarchyUniqueName;
    }

    public String getLevelType() {
        return levelType;
    }

    public boolean isVisible() {
        return visible;
    }
}
