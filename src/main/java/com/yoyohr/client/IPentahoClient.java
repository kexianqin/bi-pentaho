package com.yoyohr.client;

import com.yoyohr.client.resource.UserResource;

import java.util.ArrayList;

/**
 * 访问Pentaho BI服务
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public interface IPentahoClient {

    boolean createDir(String path) throws Exception;

    ArrayList<String> getUsers() throws Exception;

    boolean isAuthorized(String actionName) throws Exception;

}
