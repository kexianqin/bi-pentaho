package com.yoyohr.client.resource.saiku;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.yoyohr.client.Response;
import com.yoyohr.client.resource.Resource;
import com.yoyohr.client.resource.saiku.bean.Session;
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
public class SessionResource extends Resource {

    private static final Logger logger = LoggerFactory.getLogger(SessionResource.class);

    public static final String REST_SAIKU_SESSION = "/rest/saiku/session";

    private JsonFactory jsonFactory;
    private Session session;

    public SessionResource(Response response) {
        super(response);
        jsonFactory = new JsonFactory();
        session = new Session();
    }

    /**
     * 读取Session信息
     * Example: {"language":"en","sessionid":"b7e6cc39-2516-4a88-90b4-6e854294e2f5","isadmin":true,
     * "authid":"76F5D82581EB579FFCE70DB6494C52D8","roles":["ROLE_ADMIN","ROLE_USER"],
     * "username":"pentaho"}
     *
     * @return Session
     * @throws IOException
     */
    public Session getRestSaikuSession() throws IOException {
        parseJson(response.getData());
        return session;
    }

    private void parseJson(String jsonString) throws IOException {
        JsonParser jsonParser = jsonFactory.createParser(jsonString);
        jsonParser.nextToken(); // will return JsonToken.START_OBJECT (verify?)
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldName = jsonParser.getCurrentName();
            jsonParser.nextToken(); // move to value, or START_OBJECT/START_ARRAY
            logger.info(jsonParser.getText());
            if ("authid".equals(fieldName)) {
                session.setAuthId(jsonParser.getValueAsString());
            } else if ("isadmin".equals(fieldName)) {
                session.setAdmin(jsonParser.getBooleanValue());
            } else if ("language".equals(fieldName)) {
                session.setLanguage(jsonParser.getValueAsString());
            } else if ("roles".equals(fieldName)) {
                List<String> roles = new ArrayList<>();
                while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                    logger.info(jsonParser.getText());
                    roles.add(jsonParser.getValueAsString());
                }
                session.setRoles(roles);
            } else if ("sessionid".equals(fieldName)) {
                session.setSessionId(jsonParser.getValueAsString());
            } else if ("username".equals(fieldName)) {
                session.setUsername(jsonParser.getValueAsString());
            } else {
                throw new IllegalStateException("Unrecognized field : '" + fieldName + "'");
            }
        }
        jsonParser.close();
    }

}
