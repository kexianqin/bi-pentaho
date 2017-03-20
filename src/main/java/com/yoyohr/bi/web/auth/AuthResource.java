package com.yoyohr.bi.web.auth;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.yoyohr.client.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOError;
import java.io.IOException;

/**
 * Created by Administrator on 2017/3/15.
 */
public class AuthResource extends Resource{
    private static final Logger log = LoggerFactory.getLogger(AuthResource.class);
    private JsonFactory jsonFactory;

    public AuthResource() {
        jsonFactory=new JsonFactory();
    }
    public String getUriOfWhetherThereIsPermission() {
        return "v1/me";
    }

    public boolean determineAuth()throws IOException {
        boolean flag=false;
        JsonParser jsonParser = jsonFactory.createParser(response.getData());
        jsonParser.nextToken(); //will return JsonToken.START_OBJECT
        while(jsonParser.nextToken()!= JsonToken.END_OBJECT){
            String fieldName = jsonParser.getCurrentName();
            if("id".equals(fieldName)){
                flag=true;
                break;
            }
        }
        return flag;
    }

}
