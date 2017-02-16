package com.yoyohr.client.resource.saiku;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoyohr.client.Response;
import com.yoyohr.client.resource.Resource;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class BaseResource extends Resource {

    public static final String REST_SAIKU = "/rest/saiku";

    protected ObjectMapper objectMapper;

    public BaseResource() {
        objectMapper = new ObjectMapper();
    }

    protected JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }




}
