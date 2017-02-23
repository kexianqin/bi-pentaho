package com.yoyohr.client.resource.saiku.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
    @author kxq kexianqin@yoyohr.com
 */
public class SaikuDimensionAndMeasure {
    private List<SaikuDimensions> dimensions;
    private List<SaikuMeasures> measures;
    private SaikuProperties properties;

    public SaikuDimensionAndMeasure( ){ }

    public SaikuDimensionAndMeasure(List<SaikuDimensions> dimensions,List<SaikuMeasures> measures,SaikuProperties properties){
        this.dimensions=dimensions;
        this.measures=measures;
        this.properties=properties;
    }

    public List<SaikuDimensions> getDimensions() {
        return dimensions;
    }

    public List<SaikuMeasures> getMeasures() {
        return measures;
    }

    public SaikuProperties getProperties() {
        return properties;
    }

    public String toString(){
        return dimensions.toString();
    }
}
