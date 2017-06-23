package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="aces",propOrder = {})
@XmlRootElement
public class Aces {
    @XmlElement
    private String tenantPath;

    @XmlElement
    private boolean modifiable;

    @XmlElement
    private String recipient;

    @XmlElement
    private String recipientType;

    @XmlElement(name="permissions")
    private List<String> permissionsList;

    public String getTenantPath() {
        return tenantPath;
    }

    public void setTenantPath(String tenantPath) {
        this.tenantPath = tenantPath;
    }

    public boolean getModifiable() {
        return modifiable;
    }

    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }

    public List getPermissions() {
        return permissionsList;
    }

    public void setPermissions(List permissions) {
        this.permissionsList = permissions;
    }

    public Aces() {
    }

    @Override
    public String toString() {
        return "Aces{" +
            "tenantPath='" + tenantPath + '\'' +
            ", modifiable='" + modifiable + '\'' +
            ", recipient='" + recipient + '\'' +
            ", recipientType='" + recipientType + '\'' +
            ", permissions=" + permissionsList +
            '}';
    }
}
