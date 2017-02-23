package com.yoyohr.client.resource.saiku.bean;

import java.util.*;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuCubeMetadata {

    private List<SaikuDimension> dimensions;
    private List<SaikuMeasure> measures;
    private Map<String, Object> properties;

    public SaikuCubeMetadata() {
        dimensions = new ArrayList<>();
        measures = new ArrayList<>();
        properties = new HashMap<>();
    }

    public SaikuCubeMetadata(List<SaikuDimension> dimensions, List<SaikuMeasure> measures, Map<String, Object> properties) {
        this.dimensions = dimensions;
        this.measures = measures;
        this.properties = properties;
    }

    /**
     * @return the dimensions
     */
    public List<SaikuDimension> getDimensions() {
        return dimensions;
    }

    /**
     * @return the measures
     */
    public List<SaikuMeasure> getMeasures() {
        return measures;
    }


    /**
     * @return the properties
     */
    public Map<String, Object> getProperties() {
        return properties;
    }
}
