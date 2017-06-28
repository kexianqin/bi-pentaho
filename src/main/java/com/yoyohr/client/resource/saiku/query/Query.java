package com.yoyohr.client.resource.saiku.query;

import com.yoyohr.client.resource.saiku.bean.SaikuCube;
import com.yoyohr.util.JsonUtil;
import com.yoyohr.util.UuidGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 eg:
{queryModel: {},…}
%%%%%%%%%%%%%%%%%%%%%%%%% cube:{uniqueName: "[youpin_dwh].[youpin_dwh].[youpin_dwh].[youpin_dwh]", name: "youpin_dwh",…}
%%%%%%%%%%%%%%%%%%%%%%%%% mdx:"WITH↵SET [~ROWS] AS↵    {[enterprise].[enterprise].[enterprise_name].Members}↵SELECT↵NON EMPTY {[Measures].[action_key]} ON COLUMNS,↵NON EMPTY [~ROWS] ON ROWS↵FROM [youpin_dwh]"
metadata:{}
%%%%%%%%%%%%%%%%%%%%%%%%% name:"762B40D1-71AB-9442-BE9F-DAECF9C0E22B"
parameters:{}
plugins:{}
properties:{saiku.olap.query.automatic_execution: true, saiku.olap.query.nonempty: true,…}
queryModel:{}
%%%%%%%%%%%%%%%%%%%%%%%%% queryType:"OLAP"
%%%%%%%%%%%%%%%%%%%%%%%%% type:"MDX"
 */
public class Query {
    public static final Logger log = LoggerFactory.getLogger(Query.class);

    private QueryModel queryModel;
    private SaikuCube cube;
    private String mdx;
    private String name;  //随机
    private Map<String, String> parameters = new HashMap<>();
    private Map<String, String> plugins = new HashMap<>();
    private Map<String, Object> properties = new HashMap<>();
    private Map<String, String> metadata = new HashMap<>();

    private String queryType = "OLAP";
    private String type = "MDX";

    public Query() {
        this.name = UuidGenerator.generate();
        this.queryModel = new QueryModel();
    }

    public Query(SaikuCube cube, String mdx) {
        this.cube = cube;
        this.mdx = mdx;
        this.name = UuidGenerator.generate();
        this.queryModel = new QueryModel();
    }

    public QueryModel getQueryModel() {
        return queryModel;
    }

    public void setQueryModel(QueryModel queryModel) {
        this.queryModel = queryModel;
    }

    public SaikuCube getCube() {
        return cube;
    }

    public void setCube(SaikuCube cube) {
        this.cube = cube;
    }

    public String getMdx() {
        return mdx;
    }

    public void setMdx(String mdx) {
        this.mdx = mdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Map<String, String> getPlugins() {
        return plugins;
    }

    public void setPlugins(Map<String, String> plugins) {
        this.plugins = plugins;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toJson() {
        String result = JsonUtil.toJson(this);
        log.info(result);
        return result;
    }
}
