package com.yoyohr.client.resource;

import com.yoyohr.client.Response;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class DirectoryResource extends Resource {

    public static final String CREATE_DIR = "/repo/dirs";

    private String path;

    public DirectoryResource(String path, Response response) {
        super(response);
        this.path = path;
    }

    public boolean created() {
        return response.getCode() == 0 ? true : false;
    }

}
