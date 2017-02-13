package com.yoyohr.client.resource.saiku.bean;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuCube extends AbstractSaikuObject {
    private String connection;
    private String catalog;
    private String schema;
    private String caption;
    private boolean visible;


    public SaikuCube() {
    }

    public SaikuCube(String connectionName, String uniqueCubeName, String name, String caption, String catalog,
                     String schema) {
        this(connectionName, uniqueCubeName, name, caption, catalog, schema, true);
    }

    public SaikuCube(String connectionName, String uniqueCubeName, String name, String caption, String catalog,
                     String schema, boolean visible) {
        super(uniqueCubeName, name);
        this.connection = connectionName;
        this.catalog = catalog;
        this.schema = schema;
        this.caption = caption;
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public String getUniqueName() {
        String uniqueName = "[" + connection + "].[" + catalog + "]";
        uniqueName += ".[" + schema + "].[" + getName() + "]";
        return uniqueName;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getCaption() {
        return caption;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getConnection() {
        return connection;
    }

    public String getSchema() {
        return schema;
    }

}
