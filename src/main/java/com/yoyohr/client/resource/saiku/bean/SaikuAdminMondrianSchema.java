package com.yoyohr.client.resource.saiku.bean;

/**
 * Created by Administrator on 2017/5/19.
 {
 "name": "youpin_kdwh.xml",
 "path": "/datasources/youpin_kdwh.xml",
 "type": null
 }
 */
public class SaikuAdminMondrianSchema {
    private String name;
    private String path;
    private String type;

    public SaikuAdminMondrianSchema() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setType(String type) { this.type = type;}

    public String getType() { return type; }
}
