package com.yoyohr.client.resource.pentaho.query;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public class OlapCubeStructureResult {
    private List<Dimension> dimensions ;

    private List<Measure> measures ;

    public void setDimensions(List<Dimension> dimensions){
        this.dimensions = dimensions;
    }
    public List<Dimension> getDimensions(){
        return this.dimensions;
    }
    public void setMeasures(List<Measure> measures){
        this.measures = measures;
    }
    public List<Measure> getMeasures(){
        return this.measures;
    }

    @Override
    public String toString() {
        return "OlapCubeStructureResult{" +
            "dimensions=" + dimensions +
            ", measures=" + measures +
            '}';
    }
}
