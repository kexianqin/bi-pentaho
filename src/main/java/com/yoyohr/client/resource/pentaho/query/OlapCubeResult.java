package com.yoyohr.client.resource.pentaho.query;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public class OlapCubeResult {

    @JsonProperty("catalogs")
    private List<Catalog> catalogs ;

    public OlapCubeResult() {
    }

    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    @Override
    public String toString() {
        return "OlapCubeResult{" +
            "catalogs=" + catalogs +
            '}';
    }
}
