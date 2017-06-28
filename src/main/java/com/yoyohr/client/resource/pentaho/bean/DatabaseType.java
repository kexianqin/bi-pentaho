package com.yoyohr.client.resource.pentaho.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement(name="databaseType")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType()
public class DatabaseType {


    @XmlElement
    private long defaultDatabasePort;

    @XmlElement
    private String name;

    @XmlElement
    private String shortName;

    @XmlElement
    private String extraOptionsHelpUrl;

    @XmlElement
    private List<String> supportedAccessTypes;

    public DatabaseType() {
    }

    /**
     * 后面再有其他类型的数据库,继续在if下面添加
     * @param name 数据库名称
     */
    public DatabaseType(String name){

        if (name.toLowerCase().equals("mysql")){
            this.defaultDatabasePort = 3306;
            this.name = "MySQL";
            this.shortName = "MYSQL"; //Y要大写
            this.extraOptionsHelpUrl = "http://dev.mysql.com/doc/refman/5.0/en/connector-j-reference-configuration-properties.html";
        }
    }



    public DatabaseType(long defaultDatabasePort, String name, String shortName, String extraOptionsHelpUrl) {
        new DatabaseType(defaultDatabasePort,name,shortName,extraOptionsHelpUrl,null);
    }

    public DatabaseType(long defaultDatabasePort, String name, String shortName, String extraOptionsHelpUrl, List<String> supportedAccessTypes) {
        this.defaultDatabasePort = defaultDatabasePort;
        this.name = name;
        this.shortName = shortName;
        this.extraOptionsHelpUrl = extraOptionsHelpUrl;
        this.supportedAccessTypes = supportedAccessTypes;
    }

    public long getDefaultDatabasePort() {
        return defaultDatabasePort;
    }

    public void setDefaultDatabasePort(long defaultDatabasePort) {
        this.defaultDatabasePort = defaultDatabasePort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getExtraOptionsHelpUrl() {
        return extraOptionsHelpUrl;
    }

    public void setExtraOptionsHelpUrl(String extraOptionsHelpUrl) {
        this.extraOptionsHelpUrl = extraOptionsHelpUrl;
    }

    public List<String> getSupportedAccessTypes() {
        return supportedAccessTypes;
    }

    public void setSupportedAccessTypes(List<String> supportedAccessTypes) {
        this.supportedAccessTypes = supportedAccessTypes;
    }

    @Override
    public String toString() {
        return "DatabaseType{" +
            "defaultDatabasePort=" + defaultDatabasePort +
            ", name='" + name + '\'' +
            ", shortName='" + shortName + '\'' +
            ", extraOptionsHelpUrl='" + extraOptionsHelpUrl + '\'' +
            ", supportedAccessTypes=" + supportedAccessTypes +
            '}';
    }
}
