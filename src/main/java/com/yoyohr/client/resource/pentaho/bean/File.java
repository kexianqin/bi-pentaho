package com.yoyohr.client.resource.pentaho.bean;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/21.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name="file",propOrder = {})
public class File {

    @XmlElement
    private String createdDate;

    @XmlElement
    private String path;

    @XmlElement
    private long fileSize;

    @XmlElement
    private String originalParentFolderPath;

    @XmlElement
    private String name;

    @XmlElement(name="repositoryFileAclDto")
    private RepositoryFileAclDto repositoryFileAclDto;

    @XmlElement
    private String title;

    @XmlElement
    private String lockDate;

    @XmlElement
    private String creatorId;

    @XmlElement
    private String lockMessage;

    @XmlElement
    private boolean versioned;

    @XmlElement
    private String deletedDate;

    @XmlElement
    private String versionId;

    @XmlElement
    private String locale;

    @XmlElement
    private String lockOwner;

    @XmlElement
    private String id;

    @XmlElement
    private String ownerType;

    @XmlElement
    private boolean hidden;

    @XmlElement
    private boolean folder;

    @XmlElement
    private String lastModifiedDate;

    @XmlElement
    private String description;

    @XmlElement(name="localePropertiesMapEntries")
    private List<LocalePropertiesMapEntries> localePropertiesMapEntriesList;

    @XmlElement
    private boolean locked;

    @XmlElement
    private String ownerTenantPath;

    @XmlElement
    private String owner;

    @XmlElement
    private boolean aclNode;

    public File() {
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getOriginalParentFolderPath() {
        return originalParentFolderPath;
    }

    public void setOriginalParentFolderPath(String originalParentFolderPath) {
        this.originalParentFolderPath = originalParentFolderPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RepositoryFileAclDto getRepositoryFileAclDto() {
        return repositoryFileAclDto;
    }

    public void setRepositoryFileAclDto(RepositoryFileAclDto repositoryFileAclDto) {
        this.repositoryFileAclDto = repositoryFileAclDto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isVersioned() {
        return versioned;
    }

    public void setVersioned(boolean versioned) {
        this.versioned = versioned;
    }

    public String getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(String deletedDate) {
        this.deletedDate = deletedDate;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLockOwner() {
        return lockOwner;
    }

    public void setLockOwner(String lockOwner) {
        this.lockOwner = lockOwner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
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

    public List<LocalePropertiesMapEntries> getLocalePropertiesMapEntriesList() {
        return localePropertiesMapEntriesList;
    }

    public void setLocalePropertiesMapEntriesList(List<LocalePropertiesMapEntries> localePropertiesMapEntriesList) {
        this.localePropertiesMapEntriesList = localePropertiesMapEntriesList;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getOwnerTenantPath() {
        return ownerTenantPath;
    }

    public void setOwnerTenantPath(String ownerTenantPath) {
        this.ownerTenantPath = ownerTenantPath;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isAclNode() {
        return aclNode;
    }

    public void setAclNode(boolean aclNode) {
        this.aclNode = aclNode;
    }

    @Override
    public String toString() {
        return "File{" +
            "createdDate='" + createdDate + '\'' +
            ", path='" + path + '\'' +
            ", fileSize=" + fileSize +
            ", originalParentFolderPath='" + originalParentFolderPath + '\'' +
            ", name='" + name + '\'' +
            ", repositoryFileAclDto=" + repositoryFileAclDto +
            ", title='" + title + '\'' +
            ", lockDate='" + lockDate + '\'' +
            ", creatorId='" + creatorId + '\'' +
            ", lockMessage='" + lockMessage + '\'' +
            ", versioned=" + versioned +
            ", deletedDate='" + deletedDate + '\'' +
            ", versionId='" + versionId + '\'' +
            ", locale='" + locale + '\'' +
            ", lockOwner='" + lockOwner + '\'' +
            ", id='" + id + '\'' +
            ", ownerType='" + ownerType + '\'' +
            ", hidden=" + hidden +
            ", folder=" + folder +
            ", lastModifiedDate='" + lastModifiedDate + '\'' +
            ", description='" + description + '\'' +
            ", localePropertiesMapEntriesList=" + localePropertiesMapEntriesList +
            ", locked=" + locked +
            ", ownerTenantPath='" + ownerTenantPath + '\'' +
            ", owner='" + owner + '\'' +
            ", aclNode=" + aclNode +
            '}';
    }
}
