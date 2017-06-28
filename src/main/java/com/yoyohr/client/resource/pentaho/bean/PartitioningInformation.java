package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;

/**
 * Created by Administrator on 2017/6/26.
 */
@XmlRootElement(name="partitioningInformation")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType()
public class PartitioningInformation {
    @XmlElement
    private String password;

    @XmlElement
    private String hostname;

    @XmlElement
    private String partitionId;

    @XmlElement
    private String databaseName;

    @XmlElement
    private String username;

    @XmlElement
    private long port;

    public PartitioningInformation() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(String partitionId) {
        this.partitionId = partitionId;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPort() {
        return port;
    }

    public void setPort(long port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "PartitioningInformation{" +
            "password='" + password + '\'' +
            ", hostname='" + hostname + '\'' +
            ", partitionId='" + partitionId + '\'' +
            ", databaseName='" + databaseName + '\'' +
            ", username='" + username + '\'' +
            ", port=" + port +
            '}';
    }
}
