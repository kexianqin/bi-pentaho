package com.yoyohr.client.resource.pentaho.query;

/**
 * Created by Administrator on 2017/6/30.
 */
public class QueryInfo {
    private String totalRows;

    public QueryInfo() {
    }

    public void setTotalRows(String totalRows){
        this.totalRows = totalRows;
    }
    public String getTotalRows(){
        return this.totalRows;
    }

    @Override
    public String toString() {
        return "QueryInfo{" +
            "totalRows='" + totalRows + '\'' +
            '}';
    }
}
