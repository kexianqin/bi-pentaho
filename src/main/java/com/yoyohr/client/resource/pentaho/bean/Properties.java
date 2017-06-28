package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;

/**
 * Created by Administrator on 2017/6/21.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(propOrder = {"key","value"})
public class Properties {
    @XmlElement
    private String key;

    @XmlElement
    private String value;

    public Properties() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Properties{" +
            "key='" + key + '\'' +
            ", value='" + value + '\'' +
            '}';
    }
}
