package com.yoyohr.client.resource.saiku.bean;

import java.util.List;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuCatalog extends AbstractSaikuObject {

    private List<SaikuSchema> schemas;

    public SaikuCatalog() {
        super( null, null );
    }

    public SaikuCatalog( String name, List<SaikuSchema> schemas ) {
        super( name, name );
        this.schemas = schemas;
    }

    public List<SaikuSchema> getSchemas() {
        return schemas;
    }
}
