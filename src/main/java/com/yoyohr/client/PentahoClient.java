package com.yoyohr.client;

import com.yoyohr.client.resource.ActionResource;
import com.yoyohr.client.resource.DirectoryResource;
import com.yoyohr.client.resource.UserResource;

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

    /**
     * 新建文件夹, path参数形如/home:abc
     */
    @Override
    public boolean createDir(String path) throws Exception {
        Response response = put(getApiBase() + DirectoryResource.CREATE_DIR + path);
        DirectoryResource directoryResource = new DirectoryResource(path, response);
        return directoryResource.created();
    }


    /**
     * 读取用户列表
     */
    @Override
    public ArrayList<String> getUsers() throws Exception {
        Response response = get(getApiBase() + UserResource.LIST_USERS);
        UserResource userResource = new UserResource(response);
        System.out.println(userResource.toString());
        return userResource.getUsers();
    }


    /**
     * 验证当前用户能否执行ActionResource操作。
     */
    @Override
    public boolean isAuthorized(String actionName) throws Exception {
        Response response = get(getApiBase() + ActionResource.IS_AUTHORIZED + actionName);
        ActionResource actionResource = new ActionResource(actionName, response);
        return actionResource.isAuthorized();
    }


    private String getApiBase() {
        return this.target.toURI() + "/" + PENTAHO_CONTEXT + "/api";
    }

    public static void main(String[] args) throws Exception {
        PentahoClient client = new PentahoClient();
        client.getUsers();
//        System.out.println(client.createDir("/home:123"));
//        ArrayList<UserResource> users = client.getUsers();
//        System.out.println(users.size());
//        for (UserResource user : users) {
//            System.out.println("user : " + user);
//        }

//        System.out.println(client.isAuthorized(ActionResource.REPOSITORY_CREATE));

        client.close();
    }


}
