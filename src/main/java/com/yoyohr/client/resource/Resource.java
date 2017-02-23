package com.yoyohr.client.resource;

import com.yoyohr.client.Response;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class Resource {

    protected Response response;

    public Resource() {}

    public Resource(Response response) {
        this.setResponse(response);
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
