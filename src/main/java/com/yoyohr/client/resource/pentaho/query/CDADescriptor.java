package com.yoyohr.client.resource.pentaho.query;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {})
@XmlRootElement(name="CDADescriptor")
public class CDADescriptor {

    @XmlElementWrapper(name="DataSources")
    @XmlElement(name="Connection")
    List<Connection> connectionList;

    @XmlElement(name="DataAccess")
    List<DataAccess> dataAccessList;

    public CDADescriptor() {
    }

    public List<Connection> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<Connection> connectionList) {
        this.connectionList = connectionList;
    }

    public List<DataAccess> getDataAccessList() {
        return dataAccessList;
    }

    public void setDataAccessList(List<DataAccess> dataAccessList) {
        this.dataAccessList = dataAccessList;
    }

    @Override
    public String toString() {
        return "CDADescriptor{" +
            "connectionList=" + connectionList +
            ", dataAccessList=" + dataAccessList +
            '}';
    }
}
