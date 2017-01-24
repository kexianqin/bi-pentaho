package com.yoyohr.client;

import com.yoyohr.client.resource.*;

import java.util.ArrayList;
import java.util.HashMap;

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

    public PentahoClient() {
        super(PENTAHO_PROTOCOL, PENTAHO_HOST, PENTAHO_PORT, PENTAHO_USERNAME, PENTAHO_PASSWORD);
    }

    /**
     * 检查当前用户是否为系统管理员
     */
    @Override
    public boolean canAdminister() throws Exception {
        Response response = get(getApiBase() + FileResource.FILES_CAN_ADMINISTER);
        FileResource resource = new FileResource(response);
        return resource.canAdminister();
    }

    /**
     * 备份系统
     */
    @Override
    public String backupSystem() throws Exception {
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
     * 删除文件（将文件移动到trash文件夹）
     */
    @Override
    public boolean deleteFiles(String files) throws Exception {
        System.out.println(files);
        HashMap<String, String> params = new HashMap<>();
        params.put("params", files);
        Response response = put(getApiBase() + FileResource.FILES_DELETE, params);
        FileResource resource = new FileResource(response);
        System.out.println(response.getData());
        return resource.delete();
    }

    /**
     * 彻底删除文件
     */
    @Override
    public boolean deleteFilesPermanent(String files) throws Exception {
        Response response = put(getApiBase() + FileResource.FILES_DELETE_PERMANENT + files);
        FileResource resource = new FileResource(response);
        System.out.println(response.getData());
        return resource.deletePermanent();
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
     * 读取文件或文件夹,文件名形如:home:admin
     */
    @Override
    public String getFileOrDir(String path) throws Exception {
        Response response = download(getApiBase() + FileResource.FILES + path);
        FileResource resource = new FileResource(response);
        return resource.getFileOrDir();
    }

    @Override
    public String getSchedulerJobs() throws Exception {
        Response response = get(getApiBase() + SchedulerResource.SCHEDULER_GET_JOBS);
        SchedulerResource resource = new SchedulerResource(response);
        return resource.getJobs();
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
        System.out.println(client.getSchedulerJobs());
//        System.out.println(client.getFileOrDir(":home:admin:test.cda"));
//        System.out.println(client.deleteFiles(":admin:test.wcdf"));
//        ArrayList<UserResource> users = client.getUsers();
//        System.out.println(users.size());
//        for (UserResource user : users) {
//            System.out.println("user : " + user);
//        }

//        System.out.println(client.isEmailConfigurationValid());

        client.close();
    }


}
