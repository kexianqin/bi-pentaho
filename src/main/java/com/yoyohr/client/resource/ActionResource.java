package com.yoyohr.client.resource;

import com.yoyohr.client.Response;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class ActionResource {

    public static final String ADMINISTER_SECURITY = "org.pentaho.security.administerSecurity";

    public static final String PUBLISH = "org.pentaho.security.publish";

    public static final String REPOSITORY_CREATE = "org.pentaho.repository.create";

    public static final String REPOSITORY_READ = "org.pentaho.repository.read";

    public static final String IS_AUTHORIZED = "/authorization/action/isauthorized?authAction=";

    private String name;
    private Response response;

    public ActionResource(String name, Response response) {
        this.name = name;
        this.response = response;
    }

    public String getName() {
        return name;
    }

    public boolean isAuthorized() {
        return "true".equalsIgnoreCase(response.getData()) ? true : false;
    }
}
