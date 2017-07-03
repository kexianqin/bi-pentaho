package com.yoyohr.client.resource.pentaho.query;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/6/30.
 */

public class QueryMetadata {
    private String colName;

    private String colType;

    private int colIndex;

    public QueryMetadata() {
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public int getColIndex() {
        return colIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }

    @Override
    public String toString() {
        return "QueryMetadata{" +
            "colName='" + colName + '\'' +
            ", colType='" + colType + '\'' +
            ", colIndex=" + colIndex +
            '}';
    }
}
