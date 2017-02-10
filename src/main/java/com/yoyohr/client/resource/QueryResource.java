package com.yoyohr.client.resource;

import com.yoyohr.client.Response;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class QueryResource extends Resource {

    public static final String DO_QUERY = "/plugin/cda/api/doQuery";

    public QueryResource(Response response) {
        super(response);
    }

}
