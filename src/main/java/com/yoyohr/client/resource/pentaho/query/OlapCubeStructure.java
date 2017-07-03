package com.yoyohr.client.resource.pentaho.query;

/**
 * Created by Administrator on 2017/6/29.
 */
public class OlapCubeStructure {
    private OlapCubeStructureResult result;

    private String status;

    public OlapCubeStructure() {
    }

    public void setResult(OlapCubeStructureResult result){
        this.result = result;
    }
    public OlapCubeStructureResult getResult(){
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
        return "OlapCubeStructure{" +
            "result=" + result +
            ", status='" + status + '\'' +
            '}';
    }
}
