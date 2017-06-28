package com.yoyohr.client.resource.pentaho.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement(name="databaseConnection")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType()
public class DatabaseConnectionX {

    @XmlElement
    private boolean changed;

    @XmlElement
    private String hostname;

    @XmlElement
    private String databaseName;

    @XmlElement
    private String username;

    @XmlElement
    private String password;

    @XmlElement
    private String name;

    @XmlElement
    private String databasePort;

    @XmlElement
    private String id;

    @XmlElement
    private long initialPoolSize;

    @XmlElement
    private long maximumPoolSize;

    @XmlElement
    private String accessType;

    @XmlElement
    private String accessTypeValue;

    @XmlElement
    private boolean usingConnectionPool;

    @XmlElement
    private boolean quoteAllFields;

    @XmlElement
    private boolean forcingIdentifiersToUpperCase;

    @XmlElement
    private boolean forcingIdentifiersToLowerCase;

    @XmlElement
    private boolean streamingResults;

    @XmlElement
    private boolean partitioned;

    @XmlElement
    private boolean usingDoubleDecimalAsSchemaTableSeparator;

    @XmlElement
    private String informixServername;

    @XmlElement
    private String dataTablespace;

    @XmlElement
    private String indexTablespace;

    @XmlElement
    private String connectSql;

    @XmlElement(name="SQLServerInstance")
    private String SQLServerInstance;

    @XmlElementWrapper(name = "attributes")
    @XmlElement(name="entry")
    private List<Properties> attributesList;

    @XmlElementWrapper(name = "extraOptions")
    @XmlElement(name="entry")
    private List<Properties> extraOptionsList;

    @XmlElementWrapper(name = "connectionPoolingProperties")
    @XmlElement(name="entry")
    private List<Properties> connectionPoolingPropertiesList;

    @XmlElement
    private DatabaseType databaseType;

    @XmlElement
    private List<PartitioningInformation> partitioningInformationList;

    public DatabaseConnectionX() {
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
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

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(String databasePort) {
        this.databasePort = databasePort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getInitialPoolSize() {
        return initialPoolSize;
    }

    public void setInitialPoolSize(long initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    public long getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(long maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getAccessTypeValue() {
        return accessTypeValue;
    }

    public void setAccessTypeValue(String accessTypeValue) {
        this.accessTypeValue = accessTypeValue;
    }

    public boolean isUsingConnectionPool() {
        return usingConnectionPool;
    }

    public void setUsingConnectionPool(boolean usingConnectionPool) {
        this.usingConnectionPool = usingConnectionPool;
    }

    public boolean isQuoteAllFields() {
        return quoteAllFields;
    }

    public void setQuoteAllFields(boolean quoteAllFields) {
        this.quoteAllFields = quoteAllFields;
    }

    public boolean isForcingIdentifiersToUpperCase() {
        return forcingIdentifiersToUpperCase;
    }

    public void setForcingIdentifiersToUpperCase(boolean forcingIdentifiersToUpperCase) {
        this.forcingIdentifiersToUpperCase = forcingIdentifiersToUpperCase;
    }

    public boolean isForcingIdentifiersToLowerCase() {
        return forcingIdentifiersToLowerCase;
    }

    public void setForcingIdentifiersToLowerCase(boolean forcingIdentifiersToLowerCase) {
        this.forcingIdentifiersToLowerCase = forcingIdentifiersToLowerCase;
    }

    public boolean isStreamingResults() {
        return streamingResults;
    }

    public void setStreamingResults(boolean streamingResults) {
        this.streamingResults = streamingResults;
    }

    public boolean isPartitioned() {
        return partitioned;
    }

    public void setPartitioned(boolean partitioned) {
        this.partitioned = partitioned;
    }

    public boolean isUsingDoubleDecimalAsSchemaTableSeparator() {
        return usingDoubleDecimalAsSchemaTableSeparator;
    }

    public void setUsingDoubleDecimalAsSchemaTableSeparator(boolean usingDoubleDecimalAsSchemaTableSeparator) {
        this.usingDoubleDecimalAsSchemaTableSeparator = usingDoubleDecimalAsSchemaTableSeparator;
    }

    public String getInformixServername() {
        return informixServername;
    }

    public void setInformixServername(String informixServername) {
        this.informixServername = informixServername;
    }

    public String getDataTablespace() {
        return dataTablespace;
    }

    public void setDataTablespace(String dataTablespace) {
        this.dataTablespace = dataTablespace;
    }

    public String getIndexTablespace() {
        return indexTablespace;
    }

    public void setIndexTablespace(String indexTablespace) {
        this.indexTablespace = indexTablespace;
    }

    public String getConnectSql() {
        return connectSql;
    }

    public void setConnectSql(String connectSql) {
        this.connectSql = connectSql;
    }

    public String getSQLServerInstance() {
        return SQLServerInstance;
    }

    public void setSQLServerInstance(String SQLServerInstance) {
        this.SQLServerInstance = SQLServerInstance;
    }

    public List<Properties> getAttributesList() {
        return attributesList;
    }

    public void setAttributesList(List<Properties> attributesList) {
        this.attributesList = attributesList;
    }

    public List<Properties> getExtraOptionsList() {
        return extraOptionsList;
    }

    public void setExtraOptionsList(List<Properties> extraOptionsList) {
        this.extraOptionsList = extraOptionsList;
    }

    public List<Properties> getConnectionPoolingPropertiesList() {
        return connectionPoolingPropertiesList;
    }

    public void setConnectionPoolingPropertiesList(List<Properties> connectionPoolingPropertiesList) {
        this.connectionPoolingPropertiesList = connectionPoolingPropertiesList;
    }

    public DatabaseType getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(DatabaseType databaseType) {
        this.databaseType = databaseType;
    }

    public List<PartitioningInformation> getPartitioningInformationList() {
        return partitioningInformationList;
    }

    public void setPartitioningInformationList(List<PartitioningInformation> partitioningInformationList) {
        this.partitioningInformationList = partitioningInformationList;
    }

    @Override
    public String toString() {
        return "DatabaseConnectionX{" +
            "changed=" + changed +
            ", hostname='" + hostname + '\'' +
            ", databaseName='" + databaseName + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", databasePort=" + databasePort +
            ", id='" + id + '\'' +
            ", initialPoolSize=" + initialPoolSize +
            ", maximumPoolSize=" + maximumPoolSize +
            ", accessType='" + accessType + '\'' +
            ", accessTypeValue='" + accessTypeValue + '\'' +
            ", usingConnectionPool=" + usingConnectionPool +
            ", quoteAllFields=" + quoteAllFields +
            ", forcingIdentifiersToUpperCase=" + forcingIdentifiersToUpperCase +
            ", forcingIdentifiersToLowerCase=" + forcingIdentifiersToLowerCase +
            ", streamingResults=" + streamingResults +
            ", partitioned=" + partitioned +
            ", usingDoubleDecimalAsSchemaTableSeparator=" + usingDoubleDecimalAsSchemaTableSeparator +
            ", informixServername='" + informixServername + '\'' +
            ", dataTablespace='" + dataTablespace + '\'' +
            ", indexTablespace='" + indexTablespace + '\'' +
            ", connectSql='" + connectSql + '\'' +
            ", SQLServerInstance='" + SQLServerInstance + '\'' +
            ", attributesList=" + attributesList +
            ", extraOptionsList=" + extraOptionsList +
            ", connectionPoolingPropertiesList=" + connectionPoolingPropertiesList +
            ", databaseType=" + databaseType +
            ", partitioningInformationList=" + partitioningInformationList +
            '}';
    }
}
