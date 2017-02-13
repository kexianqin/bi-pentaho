package com.yoyohr.client.resource.pentaho;

import com.yoyohr.client.Response;
import com.yoyohr.client.resource.Resource;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class EmailResource extends Resource {

    public static final String GET_EMAIL_CONFIG = "/api/emailconfig/getEmailConfig";

    public static final String IS_VALID = "/api/emailconfig/isValid";

    public EmailResource(Response response) {
        super(response);
    }

    public String getEmailConfig() {
        return response.getData();
    }

    public boolean isValid() {
        return "true".equalsIgnoreCase(response.getData()) ? true : false;
    }
}
