package com.yoyohr.client.resource.saiku;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by Administrator on 2017/2/22.
 * @author kxq kexianqin@yoyohr.com
 */
public class  JsonDecode {

    private ObjectMapper objectMapper;
    private static final Logger log = LoggerFactory.getLogger(JsonDecode.class);

    public JsonDecode( ) {
        objectMapper = new ObjectMapper();
    }

    public  <T> T decode(String json, Class<T> valueType ) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonParseException e) {
            log.error("decode(String, Department<T>)", e);
        } catch (JsonMappingException e) {
            log.error("decode(String, Department<T>)", e);
        } catch (IOException e) {
            log.error("decode(String, Department<T>)", e);
        }
        return null;
    }
    public  <T> T decode(String json, TypeReference<T> jsonTypeReference) {
        try {
            return  objectMapper.readValue(json, jsonTypeReference);
        } catch (JsonParseException e) {
            log.error("decode(String, JsonTypeReference<T>)", e);
        } catch (JsonMappingException e) {
            log.error("decode(String, JsonTypeReference<T>)", e);
        } catch (IOException e) {
            log.error("decode(String, JsonTypeReference<T>)", e);
        }
        return null;
    }

}
