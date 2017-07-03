package com.yoyohr.client.resource.pentaho.query;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Administrator on 2017/6/30.
 */
public class QueryResult {
    @JsonProperty("metadata")
    private List<QueryMetadata> metadata ;
    @JsonProperty("resultset")
    private List<List> resultset ;
    @JsonProperty("queryInfo")
    private QueryInfo queryInfo;

    public QueryResult() {
    }

    public List<QueryMetadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<QueryMetadata> metadata) {
        this.metadata = metadata;
    }

    public List<List> getResultset() {
        return resultset;
    }

    public void setResultset(List<List> resultset) {
        this.resultset = resultset;
    }

    public QueryInfo getQueryInfo() {
        return queryInfo;
    }

    public void setQueryInfo(QueryInfo queryInfo) {
        this.queryInfo = queryInfo;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
            "metadata=" + metadata +
            ", resultset=" + resultset +
            ", queryInfo=" + queryInfo +
            '}';
    }
}
