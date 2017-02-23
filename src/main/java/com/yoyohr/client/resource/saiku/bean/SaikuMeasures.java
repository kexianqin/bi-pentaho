package com.yoyohr.client.resource.saiku.bean;

/**
 * Created by Administrator on 2017/2/22.
 * @author kxq kexianqin@yoyohr.com
 */
public class SaikuMeasures extends AbstractSaikuObject {
    private String caption;
    private String dimensionUniqueName;
    private String description;
    private String levelUniqueName;
    private String hierarchyUniqueName;
    private String calculated;
    private String measureGroup;

    public SaikuMeasures() { }

    public SaikuMeasures(String uniqueName,String name,String caption,String dimensionUniqueName,String description
    ,String levelUniqueName,String hierarchyUniqueName,String calculated,String measureGroup) {
        super(uniqueName, name);
        this.levelUniqueName = levelUniqueName;
        this.calculated=calculated;
        this.caption=caption;
        this.description=description;
        this.dimensionUniqueName=dimensionUniqueName;
        this.hierarchyUniqueName=hierarchyUniqueName;
        this.measureGroup=measureGroup;
    }

    public String getCalculated() {
        return calculated;
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

    public String getLevelUniqueName() {
        return levelUniqueName;
    }

    public String getMeasureGroup() {
        return measureGroup;
    }
}
