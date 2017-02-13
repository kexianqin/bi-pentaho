package com.yoyohr.client.resource.pentaho;

import com.yoyohr.client.Response;
import com.yoyohr.client.resource.Resource;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class DirectoryResource extends Resource {

    public static final String CREATE_DIR = "/api/repo/dirs";

    private String path;

    public DirectoryResource(String path, Response response) {
        super(response);
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public boolean created() {
        return response.getCode() == 0 ? true : false;
    }

}
