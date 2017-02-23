package com.yoyohr.client.resource.saiku.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/2/22.
 * @author kxq kexianqin@yoyohr.com
 */

/**
 * 该类中内容由于名字问题没有正常反序列化，故用下面注解进行忽视。
 * 放在类前：@JsonIgnoreProperties(ignoreUnknown = true)
 */

/**
 * 第二次修改，下面的注释解决了名字的问题
 */

public class SaikuProperties {
    @JsonProperty("org.saiku.query.explain")
    private boolean orgSaikuQueryExplain;
    @JsonProperty("saiku.olap.query.drillthrough")
    private boolean saikuOlapQueryDrillthrough;
    @JsonProperty("org.saiku.connection.scenario")
    private boolean orgSaikuConnectionScenario;

    public SaikuProperties(){}

    public SaikuProperties(boolean orgSaikuConnectionScenario,boolean orgSaikuQueryExplain,boolean saikuOlapQueryDrillthrough) {
        this.orgSaikuConnectionScenario = orgSaikuConnectionScenario;
        this.orgSaikuQueryExplain=orgSaikuQueryExplain;
        this.saikuOlapQueryDrillthrough=saikuOlapQueryDrillthrough;
    }

    public boolean isOrgSaikuConnectionScenario() {
        return orgSaikuConnectionScenario;
    }

    public boolean isOrgSaikuQueryExplain() {
        return orgSaikuQueryExplain;
    }

    public boolean isSaikuOlapQueryDrillthrough() {
        return saikuOlapQueryDrillthrough;
    }
}
