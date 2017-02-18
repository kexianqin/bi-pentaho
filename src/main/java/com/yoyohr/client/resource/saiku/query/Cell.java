package com.yoyohr.client.resource.saiku.query;

import java.util.Properties;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class Cell {

    private String value;
    private String type;
    private Properties properties = new Properties();

    public enum Type {
        ROW_HEADER,
        ROW_HEADER_HEADER,
        COLUMN_HEADER,
        DATA_CELL,
        EMPTY,
        UNKNOWN,
        ERROR
    }

    public Cell() {
    }

    public Cell(String value) {
        this(value, Type.EMPTY);
    }

    public Cell(String value, Properties properties, Type type) {
        this.value = value;
        this.properties.putAll(properties);
        this.type = type.toString();
    }

    public Cell(String value, Type type) {
        this.value = value;
        this.type = type.toString();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}

