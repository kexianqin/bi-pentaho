package com.yoyohr.client.resource.saiku.bean;

/**
 * Created by Administrator on 2017/2/23.
 */
public class SaikuHierarchiesRootMembers extends AbstractSaikuObject {

    private String caption;
    private String dimensionUniqueName;
    private String description;
    private String levelUniqueName;
    private String hierarchyUniqueName;
    private boolean calculated;

    public SaikuHierarchiesRootMembers() {
    }

    public SaikuHierarchiesRootMembers(String uniqueName, String name, boolean calculated, String hierarchyUniqueName, String levelUniqueName, String description
            , String dimensionUniqueName, String caption) {
        super(uniqueName, name);
        this.calculated = calculated;
        this.caption = caption;
        this.dimensionUniqueName = dimensionUniqueName;
        this.description = description;
        this.levelUniqueName = levelUniqueName;
        this.hierarchyUniqueName = hierarchyUniqueName;
    }

    public boolean isCalculated() {
        return calculated;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public String getHierarchyUniqueName() {
        return hierarchyUniqueName;
    }

    public String getDimensionUniqueName() {
        return dimensionUniqueName;
    }

    public String getLevelUniqueName() {
        return levelUniqueName;
    }
}
