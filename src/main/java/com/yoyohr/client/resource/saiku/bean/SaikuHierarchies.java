package com.yoyohr.client.resource.saiku.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class SaikuHierarchies extends AbstractSaikuObject {
    private String caption;
    private String dimensionUniqueName;
    private List<SaikuLevels> levels;
    private String description;
    private boolean visible;
    private List<SaikuHierarchiesRootMembers> rootMembers;

    public SaikuHierarchies() {
    }

    public SaikuHierarchies(List<SaikuLevels> levels, String caption, String dimensionUniqueName, String uniqueName, String name,
                            String description, boolean visible, List<SaikuHierarchiesRootMembers> rootMembers) {
        super(uniqueName, name);
        this.levels = levels;
        this.caption = caption;
        this.dimensionUniqueName = dimensionUniqueName;
        this.description = description;
        this.visible = visible;
        this.rootMembers = rootMembers;
    }

    public String getCaption() {
        return caption;
    }

    public String getDimensionUniqueName() {
        return dimensionUniqueName;
    }

    public List<SaikuLevels> getLevels() {
        return levels;
    }

    public String getDescription() {
        return description;
    }

    public List<SaikuHierarchiesRootMembers> getRootMembers() {
        return rootMembers;
    }

    public boolean isVisible() {
        return visible;
    }
}
