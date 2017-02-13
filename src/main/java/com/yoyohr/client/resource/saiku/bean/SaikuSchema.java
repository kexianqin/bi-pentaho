package com.yoyohr.client.resource.saiku.bean;

import java.util.List;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuSchema extends AbstractSaikuObject {

    private List<SaikuCube> cubes;

    public SaikuSchema() {
        super( null, null );
    }

    public SaikuSchema( String name, List<SaikuCube> cubes ) {
        super( name, name );
        this.cubes = cubes;
    }

    public List<SaikuCube> getCubes() {
        return cubes;
    }
}
