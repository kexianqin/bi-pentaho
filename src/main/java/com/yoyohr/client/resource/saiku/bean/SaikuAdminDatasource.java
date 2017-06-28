package com.yoyohr.client.resource.saiku.bean;

/**
 * Created by Administrator on 2017/5/19.
 {
 "connectionname": "youpin_kdwh",
 "jdbcurl": "jdbc:mysql://192.168.1.124:3306/youpin_kdwh_srm",
 "schema": "mondrian:///datasources/youpin_kdwh.xml",
 "driver": "com.mysql.jdbc.Driver",
 "username": "root",
 "password": "123456",
 "connectiontype": "MONDRIAN",
 "id": "96a8b135-0faa-4de3-8beb-b0005d09ed18",
 "path": "/datasources/youpin_kdwh.sds",
 "advanced": null,
 "security_type": null,
 "propertyKey": null
 }
 */
public class SaikuAdminDatasource {
    private String connectionname;
    private String jdbcurl;
    private String schema;
    private String driver;
    private String username;
    private String password;
    private String connectiontype;
    private String id;
    private String path;
    private String advanced;
    private String security_type;
    private String propertyKey;

    public SaikuAdminDatasource() {
    }

    public String getConnectionname() {
        return connectionname;
    }

    public void setConnectionname(String connectionname) {
        this.connectionname = connectionname;
    }

    public String getJdbcurl() {
        return jdbcurl;
    }

    public void setJdbcurl(String jdbcurl) {
        this.jdbcurl = jdbcurl;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectiontype() {
        return connectiontype;
    }

    public void setConnectiontype(String connectiontype) {
        this.connectiontype = connectiontype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAdvanced() {
        return advanced;
    }

    public void setAdvanced(String advanced) {
        this.advanced = advanced;
    }

    public void setSecurity_type(String security_type) {
        this.security_type = security_type;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public String getSecurity_type() {
        return security_type;
    }
}
