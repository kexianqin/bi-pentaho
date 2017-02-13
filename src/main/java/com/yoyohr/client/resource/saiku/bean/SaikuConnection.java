package com.yoyohr.client.resource.saiku.bean;

import java.util.List;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuConnection extends AbstractSaikuObject {

    private List<SaikuCatalog> catalogs;

    public SaikuConnection() {
        super( null, null );
    }

    public SaikuConnection( String connectionName, List<SaikuCatalog> catalogs ) {
        super( connectionName, connectionName );
        this.catalogs = catalogs;
    }

    public List<SaikuCatalog> getCatalogs() {
        return catalogs;
    }
}
