package com.yoyohr.client.resource.saiku;

import com.fasterxml.jackson.core.JsonFactory;
import com.yoyohr.client.Response;
import com.yoyohr.client.resource.Resource;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class BaseResource extends Resource {

    public static final String REST_SAIKU = "/rest/saiku/";



    public BaseResource(Response response) {
        super(response);
    }
}
