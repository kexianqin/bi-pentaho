package com.yoyohr.client;

import com.yoyohr.client.resource.UserResource;

import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * 访问Pentaho BA服务
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public interface IPentahoClient {

    String backup() throws Exception;

    boolean createDir(String path) throws Exception;

    String getEmailConfig() throws Exception;

    ArrayList<String> getUsers() throws Exception;

    boolean isActionAuthorized(String actionName) throws Exception;

    boolean isEmailConfigurationValid() throws Exception;



}
