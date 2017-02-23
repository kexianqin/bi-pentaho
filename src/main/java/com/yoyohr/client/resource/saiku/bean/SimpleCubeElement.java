package com.yoyohr.client.resource.saiku.bean;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SimpleCubeElement extends AbstractSaikuObject {

    private String caption;

    public SimpleCubeElement() {
    }

    public SimpleCubeElement(String name, String uniqueName, String caption) {
        super(uniqueName, name);
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

}

