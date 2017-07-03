package com.yoyohr.client.resource.pentaho.query;

import javax.xml.bind.annotation.*;

/**
 * Created by Administrator on 2017/6/29.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"catalog","jndi"})
@XmlRootElement(name="Connection")
public class Connection {

    @XmlElement(name="Catalog")
    String catalog;

    @XmlElement(name="Jndi")
    String jndi;

    @XmlAttribute(name="id")
    String id;

    @XmlAttribute(name="type")
    String type;

    public Connection() {
    }

    public Connection(String catalog, String jndi, String id, String type) {
        this.catalog = catalog;
        this.jndi = jndi;
        this.id = id;
        this.type = type;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getJndi() {
        return jndi;
    }

    public void setJndi(String jndi) {
        this.jndi = jndi;
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

    @Override
    public String toString() {
        return "Connection{" +
            "catalog='" + catalog + '\'' +
            ", jndi='" + jndi + '\'' +
            ", id='" + id + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}
