package com.yoyohr.client.resource;

import com.yoyohr.client.Response;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class DirectoryResource {

    public static final String CREATE_DIR = "/repo/dirs";

    private String path;
    private Response response;

    public DirectoryResource(String path, Response response) {
        this.path = path;
        this.response = response;
    }

    public boolean created() {
        return this.response.getCode() == 0 ? true : false;
    }

}
