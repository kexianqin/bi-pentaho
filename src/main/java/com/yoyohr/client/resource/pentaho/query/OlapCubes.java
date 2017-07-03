package com.yoyohr.client.resource.pentaho.query;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/6/29.
 */
public class OlapCubes {
    @JsonProperty("result")
    private OlapCubeResult result;

    private String status;

    public OlapCubes() {
    }

    public void setResult(OlapCubeResult result){
        this.result = result;
    }
    public OlapCubeResult getResult(){
        return this.result;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }

    @Override
    public String toString() {
        return "OlapCubes{" +
            "result=" + result +
            ", status='" + status + '\'' +
            '}';
    }
}
