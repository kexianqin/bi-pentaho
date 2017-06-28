package com.yoyohr.client.resource.pentaho.bean;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/26.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class DatabaseConnectionJ {

    private boolean changed;
    private String hostname;
    private String databaseName;
    private String username;
    private String password;
    private String name;
    private String databasePort;
    private String id;
    private long initialPoolSize;
    private long maximumPoolSize;
    private String accessType;
    private String accessTypeValue;
    private boolean usingConnectionPool;
    private boolean quoteAllFields;
    private boolean forcingIdentifiersToUpperCase;
    private boolean forcingIdentifiersToLowerCase;
    private boolean streamingResults;
    private boolean partitioned;
    private boolean usingDoubleDecimalAsSchemaTableSeparator;
    private String informixServername;
    private String dataTablespace;
    private String indexTablespace;
    private String connectSql;

    @JsonProperty("SQLServerInstance")
    private String SQLServerInstance;

    private Map<String,String> attributes;
    private Map<String,String> extraOptions;
    private Map<String,String> extraOptionsOrder;
    private Map<String,String> connectionPoolingProperties;

    private DatabaseType databaseType;

    @JsonProperty("partitioningInformation")
    private List<PartitioningInformation> partitioningInformationList;

    public DatabaseConnectionJ() {
    }

    /**
     * accessType ...后面如果变化再改或者放到参数中去
     */
    public DatabaseConnectionJ(String connectionName, String databaseTypeName,String hostname,
                               String databasePort,String databaseName,String username,String password,boolean changed) {
        DatabaseType databaseType1 = new DatabaseType(databaseTypeName);
        this.name=connectionName;
        this.databaseType=databaseType1;
        this.hostname=hostname;
        this.databasePort=databasePort;
        this.databaseName=databaseName;
        this.username=username;
        this.password=password;
        this.changed=changed;
        this.accessType="NATIVE";
        this.usingConnectionPool=true;
//        this.accessTypeValue="";
//        this.attributes=new HashMap<>();
//        this.connectSql="";
//        this.connectionPoolingProperties=new HashMap<>();
//        this.dataTablespace="";
//        this.extraOptions=new HashMap<>();
//        this.extraOptionsOrder=new HashMap<>();
//        this.id ="";
//        this.indexTablespace="";
//        this.informixServername="";
    }

    public DatabaseConnectionJ(String connectionName, String databaseTypeName,String hostname,
                               String databasePort,String databaseName,String username,String password,boolean changed,
                                String accessType,boolean usingConnectionPool){
        this(connectionName, databaseTypeName,hostname,
            databasePort,databaseName,username,password,changed);
        this.accessType=accessType;
        this.usingConnectionPool=usingConnectionPool;
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

    public void setUsername(String username) {
        this.username = username;
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

    public Map<String, String> getExtraOptionsOrder() {
        return extraOptionsOrder;
    }

    public void setExtraOptionsOrder(Map<String, String> extraOptionsOrder) {
        this.extraOptionsOrder = extraOptionsOrder;
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

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Map<String, String> getExtraOptions() {
        return extraOptions;
    }

    public void setExtraOptions(Map<String, String> extraOptions) {
        this.extraOptions = extraOptions;
    }

    public Map<String, String> getConnectionPoolingProperties() {
        return connectionPoolingProperties;
    }

    public void setConnectionPoolingProperties(Map<String, String> connectionPoolingProperties) {
        this.connectionPoolingProperties = connectionPoolingProperties;
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
        return "DatabaseConnectionJ{" +
            "changed=" + changed +
            ", hostname='" + hostname + '\'' +
            ", databaseName='" + databaseName + '\'' +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", databasePort='" + databasePort + '\'' +
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
            ", attributes=" + attributes +
            ", extraOptions=" + extraOptions +
            ", extraOptionsOrder=" + extraOptionsOrder +
            ", connectionPoolingProperties=" + connectionPoolingProperties +
            ", databaseType=" + databaseType +
            ", partitioningInformationList=" + partitioningInformationList +
            '}';
    }
}
