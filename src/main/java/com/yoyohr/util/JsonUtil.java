package com.yoyohr.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class JsonUtil {

    private static ObjectMapper objectMapper;

    public static <T> T parseJson(String jsonString, Class<T> typeValue) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(jsonString, typeValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T parseJson(String jsonString, TypeReference<T> valueTypeRef) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.readValue(jsonString, valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String toJson(Object object) {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
