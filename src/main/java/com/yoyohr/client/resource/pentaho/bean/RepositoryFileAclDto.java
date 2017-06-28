package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name="repositoryFileAclDto",propOrder = {})
public class RepositoryFileAclDto {

    @XmlElement
    private boolean entriesInheriting;

    @XmlElement
    private String owner;

    @XmlElement
    private long ownerType;

    @XmlElement
    private String tenantPath;

    @XmlElement
    private String id;

    @XmlElement(name="aces")
    private List<Aces> acesList;

    public RepositoryFileAclDto() {
    }

    public boolean  getEntriesInheriting() {
        return entriesInheriting;
    }

    public void setEntriesInheriting(boolean  entriesInheriting) {
        this.entriesInheriting = entriesInheriting;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(long ownerType) {
        this.ownerType = ownerType;
    }

    public String getTenantPath() {
        return tenantPath;
    }

    public void setTenantPath(String tenantPath) {
        this.tenantPath = tenantPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Aces> getAcesList() {
        return acesList;
    }

    public void setAcesList(List<Aces> acesList) {
        this.acesList = acesList;
    }

    @Override
    public String toString() {
        return "RepositoryFileAclDto{" +
            "entriesInheriting='" + entriesInheriting + '\'' +
            ", owner='" + owner + '\'' +
            ", ownerType=" + ownerType +
            ", tenantPath='" + tenantPath + '\'' +
            ", id='" + id + '\'' +
            ", acesList=" + acesList +
            '}';
    }
}
