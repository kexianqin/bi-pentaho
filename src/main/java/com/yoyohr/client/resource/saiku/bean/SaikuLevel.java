package com.yoyohr.client.resource.saiku.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuLevel extends AbstractSaikuObject {

    private Map<String, String> annotations;
    private String levelType;
    private String caption;
    private String hierarchyUniqueName;
    private String dimensionUniqueName;
    private boolean visible;
    private String description;

    public SaikuLevel() {
        super(null, null);
    }


    public SaikuLevel(
            String name,
            String uniqueName,
            String caption,
            String description,
            String dimensionUniqueName,
            String hierarchyUniqueName,
            boolean visible,
            String levelType,
            Map<String, String> annotations) {
        super(uniqueName, name);
        this.caption = caption;
        this.hierarchyUniqueName = hierarchyUniqueName;
        this.dimensionUniqueName = dimensionUniqueName;
        this.visible = visible;
        this.description = description;
        this.annotations = annotations;
        if(levelType!=null) {
            this.levelType = levelType;
        }
    }

    public String getCaption() {
        return caption;
    }

    public String getHierarchyUniqueName() {
        return hierarchyUniqueName;
    }

    public String getDimensionUniqueName() {
        return dimensionUniqueName;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getAnnotations() {
        Map<String, String> m = null;
        if (annotations != null) {
            m = new HashMap<>();
            for (Map.Entry<String, String> entry : annotations.entrySet()) {
                m.put(entry.getKey(), entry.getValue());
            }
        }


        return m;
    }

    public String getLevelType() {
        return levelType;
    }

}

