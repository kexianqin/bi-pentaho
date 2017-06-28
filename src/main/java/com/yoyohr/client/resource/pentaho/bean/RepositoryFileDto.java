package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name="repositoryFileDto",propOrder = {})
public class RepositoryFileDto {

    @XmlElement
    private String id;

    @XmlElement
    private String path;

    @XmlElement
    private String locale;

    @XmlElement
    private String name;

    @XmlElement
    private String createdDate;

    @XmlElement
    private long fileSize;

    @XmlElement
    private boolean folder;

    @XmlElement
    private boolean hidden;

    @XmlElement
    private boolean locked;

    @XmlElement
    private String title;

    @XmlElement
    private String ownerType;

    @XmlElement
    private String originalParentFolderPath;

    @XmlElement
    private String lockDate;

    @XmlElement
    private String creatorId;

    @XmlElement
    private String lockMessage;

    @XmlElement
    private boolean versioned;

    @XmlElement
    private String deleteDate;

    @XmlElement
    private String versionId;

    @XmlElement
    private String lockOwner;

    @XmlElement
    private String lastModifiedDate;

    @XmlElement
    private String description;

    @XmlElement
    private String owner;

    @XmlElement
    private String townerTenantPath;

    @XmlElement(name="repositoryFileAclDto")
    private RepositoryFileAclDto repositoryFileAclDto;

    @XmlElement(name="localePropertiesMapEntries")
    private List<LocalePropertiesMapEntries> localePropertiesMapEntriesList;

    public RepositoryFileDto() {
    }

    public List<LocalePropertiesMapEntries> getLocalePropertiesMapEntriesList() {
        return localePropertiesMapEntriesList;
    }

    public void setLocalePropertiesMapEntriesList(List<LocalePropertiesMapEntries> localePropertiesMapEntriesList) {
        this.localePropertiesMapEntriesList = localePropertiesMapEntriesList;
    }

    public RepositoryFileAclDto getRepositoryFileAclDto() {
        return repositoryFileAclDto;
    }

    public void setRepositoryFileAclDto(RepositoryFileAclDto repositoryFileAclDto) {
        this.repositoryFileAclDto = repositoryFileAclDto;
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public boolean getFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    public boolean getHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean getLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOriginalParentFolderPath() {
        return originalParentFolderPath;
    }

    public void setOriginalParentFolderPath(String originalParentFolderPath) {
        this.originalParentFolderPath = originalParentFolderPath;
    }

    public String getLockDate() {
        return lockDate;
    }

    public void setLockDate(String lockDate) {
        this.lockDate = lockDate;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getLockMessage() {
        return lockMessage;
    }

    public void setLockMessage(String lockMessage) {
        this.lockMessage = lockMessage;
    }

    public boolean getVersioned() {
        return versioned;
    }

    public void setVersioned(boolean versioned) {
        this.versioned = versioned;
    }

    public String getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(String deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getLockOwner() {
        return lockOwner;
    }

    public void setLockOwner(String lockOwner) {
        this.lockOwner = lockOwner;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTownerTenantPath() {
        return townerTenantPath;
    }

    public void setTownerTenantPath(String townerTenantPath) {
        this.townerTenantPath = townerTenantPath;
    }

    @Override
    public String toString() {
        return "RepositoryFileDto{" +
            "id='" + id + '\'' +
            ", path='" + path + '\'' +
            ", locale='" + locale + '\'' +
            ", name='" + name + '\'' +
            ", createdDate='" + createdDate + '\'' +
            ", fileSize=" + fileSize +
            ", folder=" + folder +
            ", hidden=" + hidden +
            ", locked=" + locked +
            ", title='" + title + '\'' +
            ", ownerType=" + ownerType +
            ", originalParentFolderPath='" + originalParentFolderPath + '\'' +
            ", lockDate='" + lockDate + '\'' +
            ", creatorId='" + creatorId + '\'' +
            ", lockMessage='" + lockMessage + '\'' +
            ", versioned=" + versioned +
            ", deleteDate='" + deleteDate + '\'' +
            ", versionId='" + versionId + '\'' +
            ", lockOwner='" + lockOwner + '\'' +
            ", lastModifiedDate='" + lastModifiedDate + '\'' +
            ", description='" + description + '\'' +
            ", owner='" + owner + '\'' +
            ", townerTenantPath='" + townerTenantPath + '\'' +
            ", repositoryFileAclDto=" + repositoryFileAclDto +
            ", localePropertiesMapEntriesList=" + localePropertiesMapEntriesList +
            '}';
    }
}
