package com.yoyohr.client.resource.saiku;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.yoyohr.client.resource.saiku.bean.SaikuSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SessionResource extends BaseResource {

    private static final Logger log = LoggerFactory.getLogger(SessionResource.class);

    public static final String SESSION = "/session";

    private JsonFactory jsonFactory;

    private SaikuSession saikuSession;

    public SessionResource() {
        jsonFactory = new JsonFactory();
        saikuSession = new SaikuSession();
    }

    public SaikuSession getSaikuSession() {
        return saikuSession;
    }

    public String getUriOfGetRestSaikuSession() {
        return "/session";
    }

    /**
     * 读取Session信息
     * Example: {"language":"en","sessionid":"b7e6cc39-2516-4a88-90b4-6e854294e2f5","isadmin":true,
     * "authid":"76F5D82581EB579FFCE70DB6494C52D8","roles":["ROLE_ADMIN","ROLE_USER"],
     * "username":"pentaho"}
     *
     * Example:  {START_OBJECT
     "firstName"KEY_NAME: "John"VALUE_STRING, "lastName"KEY_NAME: "Smith"VALUE_STRING, "age"KEY_NAME: 25VALUE_NUMBER,
     "phoneNumber"KEY_NAME : [START_ARRAY
     {START_OBJECT "type"KEY_NAME: "home"VALUE_STRING, "number"KEY_NAME: "212 555-1234"VALUE_STRING }END_OBJECT,
     {START_OBJECT "type"KEY_NAME: "fax"VALUE_STRING, "number"KEY_NAME: "646 555-4567"VALUE_STRING }END_OBJECT
     ]END_ARRAY
     }END_OBJECT

     *
     * @return SaikuSession
     * @throws IOException
     */
    public SaikuSession parseSaikuSession() throws IOException {
        parseJson(response.getData());
        return saikuSession;
    }

    private void parseJson(String jsonString) throws IOException {
        JsonParser jsonParser = jsonFactory.createParser(jsonString);
        jsonParser.nextToken(); // will return JsonToken.START_OBJECT (verify?)
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonParser.getCurrentName();
            jsonParser.nextToken(); // move to value, or START_OBJECT/START_ARRAY
            if ("authid".equals(fieldName)) {
                saikuSession.setAuthId(jsonParser.getValueAsString());
            } else if ("isadmin".equals(fieldName)) {
                saikuSession.setAdmin(jsonParser.getBooleanValue());
            } else if ("language".equals(fieldName)) {
                saikuSession.setLanguage(jsonParser.getValueAsString());
            } else if ("roles".equals(fieldName)) {
                List<String> roles = new ArrayList<>();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    roles.add(jsonParser.getValueAsString());
                }
                saikuSession.setRoles(roles);
            } else if ("sessionid".equals(fieldName)) {
                saikuSession.setSessionId(jsonParser.getValueAsString());
            } else if ("username".equals(fieldName)) {
                saikuSession.setUsername(jsonParser.getValueAsString());
            } else {
                throw new IllegalStateException("Unrecognized field : '" + fieldName + "'");
            }
        }
        jsonParser.close();
    }

}
