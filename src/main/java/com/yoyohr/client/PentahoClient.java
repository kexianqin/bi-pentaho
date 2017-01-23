package com.yoyohr.client;

import com.yoyohr.client.resource.*;

import java.util.ArrayList;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class PentahoClient extends BaseHttpClient implements IPentahoClient {

    private static final String PENTAHO_PROTOCOL = "http";
    private static final String PENTAHO_HOST = "192.168.1.125";
    private static final int PENTAHO_PORT = 8080;
    private static final String PENTAHO_USERNAME = "admin";
    private static final String PENTAHO_PASSWORD = "password";

    private static final String PENTAHO_CONTEXT = "pentaho";


    private static int CODE_SUCCESS = 0;


    public PentahoClient() {
        super(PENTAHO_PROTOCOL, PENTAHO_HOST, PENTAHO_PORT, PENTAHO_USERNAME, PENTAHO_PASSWORD);
    }

    @Override
    public String backup() throws Exception {
        Response response = download(getApiBase() + FileResource.FILES_BACKUP);
        FileResource resource = new FileResource(response);
        return resource.backup();
    }

    /**
     * 新建文件夹, path参数形如/home:abc
     */
    @Override
    public boolean createDir(String path) throws Exception {
        Response response = put(getApiBase() + DirectoryResource.CREATE_DIR + path);
        DirectoryResource resource = new DirectoryResource(path, response);
        return resource.created();
    }

    /**
     * 读取系统Email配置信息
     */
    @Override
    public String getEmailConfig() throws Exception {
        Response response = get(getApiBase() + EmailResource.GET_EMAIL_CONFIG);
        EmailResource resource = new EmailResource(response);
        return resource.getEmailConfig();
    }


    /**
     * 读取用户列表
     */
    @Override
    public ArrayList<String> getUsers() throws Exception {
        Response response = get(getApiBase() + UserResource.LIST_USERS);
        UserResource resource = new UserResource(response);
        return resource.getUsers();
    }


    /**
     * 验证当前用户能否执行ActionResource操作。
     */
    @Override
    public boolean isActionAuthorized(String actionName) throws Exception {
        Response response = get(getApiBase() + ActionResource.IS_AUTHORIZED + actionName);
        ActionResource resource = new ActionResource(actionName, response);
        return resource.isAuthorized();
    }

    /**
     * 判断系统Email配置信息是否可用。
     */
    @Override
    public boolean isEmailConfigurationValid() throws Exception {
        Response response = get(getApiBase() + EmailResource.IS_VALID);
        EmailResource resource = new EmailResource(response);
        return resource.isValid();
    }


    private String getApiBase() {
        return this.target.toURI() + "/" + PENTAHO_CONTEXT + "/api";
    }

    public static void main(String[] args) throws Exception {
        PentahoClient client = new PentahoClient();
//        client.getUsers();
        System.out.println(client.backup());
//        ArrayList<UserResource> users = client.getUsers();
//        System.out.println(users.size());
//        for (UserResource user : users) {
//            System.out.println("user : " + user);
//        }

//        System.out.println(client.isEmailConfigurationValid());

        client.close();
    }


}
