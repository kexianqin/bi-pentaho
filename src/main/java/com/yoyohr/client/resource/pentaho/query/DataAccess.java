package com.yoyohr.client.resource.pentaho.query;

import javax.xml.bind.annotation.*;

/**
 * Created by Administrator on 2017/6/29.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {})
@XmlRootElement(name="DataAccess")
public class DataAccess {
    @XmlAttribute
    String access;

    @XmlAttribute
    String connection;

    @XmlAttribute
    String id;

    @XmlAttribute
    String type;

    @XmlElement(name="Name")
    String name;

    @XmlElement(name="BandedMode")
    String bandedMode;

    @XmlElement(name="Columns")
    String columns;

    @XmlElement(name="Parameters")
    String parameters;

    @XmlElement(name="Query")
    String query;

    @XmlElement(name="Cache")
    Cache cache;

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Cache {
        @XmlAttribute
        String duration;
        @XmlAttribute
        String enabled;

        public Cache() {
        }

        public Cache(String duration, String enabled) {
            this.duration = duration;
            this.enabled = enabled;
        }

        public String getDuration() {
            return duration;
        }

        @Override
        public String toString() {
            return "Cache{" +
                "duration='" + duration + '\'' +
                ", enabled='" + enabled + '\'' +
                '}';
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getEnabled() {
            return enabled;
        }

        public void setEnabled(String enabled) {
            this.enabled = enabled;
        }
    }

    public DataAccess() {
    }

    public DataAccess(String access, String connection, String id, String type, String name, String bandedMode, String query, Cache cache) {
        this.access = access;
        this.connection = connection;
        this.id = id;
        this.type = type;
        this.name = name;
        this.bandedMode = bandedMode;
        this.query = query;
        this.cache = cache;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBandedMode() {
        return bandedMode;
    }

    public void setBandedMode(String bandedMode) {
        this.bandedMode = bandedMode;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    @Override
    public String toString() {
        return "DataAccess{" +
            "access='" + access + '\'' +
            ", connection='" + connection + '\'' +
            ", id='" + id + '\'' +
            ", type='" + type + '\'' +
            ", name='" + name + '\'' +
            ", bandedMode='" + bandedMode + '\'' +
            ", colums='" + columns + '\'' +
            ", parameters='" + parameters + '\'' +
            ", query='" + query + '\'' +
            ", cache=" + cache +
            '}';
    }
}
