package com.yoyohr.client;

import com.yoyohr.client.resource.pentaho.*;
import com.yoyohr.util.PropertiesReader;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClients;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class PentahoClient extends BaseHttpClient implements IPentahoClient {

    private static final Logger log = LoggerFactory.getLogger(PentahoClient.class);

    private static final String PENTAHO_PROTOCOL = PropertiesReader.getValue("pentaho.protocol");
    private static final String PENTAHO_HOST = PropertiesReader.getValue("pentaho.host");
    private static final String PENTAHO_USERNAME = PropertiesReader.getValue("pentaho.username");
    private static final String PENTAHO_PASSWORD = PropertiesReader.getValue("pentaho.password");

    private static final String PENTAHO_CONTEXT = PropertiesReader.getValue("pentaho.context");

    public PentahoClient() {
        log.info("PentahoClient Constructing...");
        target = new HttpHost(PENTAHO_HOST, -1, PENTAHO_PROTOCOL);

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(PENTAHO_USERNAME, PENTAHO_PASSWORD));
        httpClient = HttpClients.custom().setDefaultCredentialsProvider(credentialsProvider).build();

        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(target, basicAuth);
        context = HttpClientContext.create();
        context.setAuthCache(authCache);
    }

    /**
     * 检查当前用户是否为系统管理员
     */
    @Override
    public boolean canAdminister() throws IOException {
        Response response = get(getApiBase() + FileResource.FILES_CAN_ADMINISTER);
        FileResource resource = new FileResource(response);
        return resource.canAdminister();
    }

    /**
     * 备份系统
     */
    @Override
    public String backupSystem() throws IOException {
        Response response = download(getApiBase() + FileResource.FILES_BACKUP);
        FileResource resource = new FileResource(response);
        return resource.backup();
    }

    /**
     * 新建文件夹, path参数形如/home:abc
     */
    @Override
    public boolean createDir(String path) throws IOException {
        Response response = put(getApiBase() + DirectoryResource.CREATE_DIR + path);
        DirectoryResource resource = new DirectoryResource(path, response);
        return resource.created();
    }

    /**
     * 删除文件（将文件移动到trash文件夹）
     */
    @Override
    public boolean deleteFiles(String files) throws IOException {
        log.info(files);
        HashMap<String, String> params = new HashMap<>();
        params.put("params", files);
        Response response = put(getApiBase() + FileResource.FILES_DELETE, params);
        FileResource resource = new FileResource(response);
        log.info(response.getData());
        return resource.delete();
    }

    /**
     * 彻底删除文件
     */
    @Override
    public boolean deleteFilesPermanent(String files) throws IOException {
        Response response = put(getApiBase() + FileResource.FILES_DELETE_PERMANENT + files);
        FileResource resource = new FileResource(response);
        log.info(response.getData());
        return resource.deletePermanent();
    }

    /**
     * 执行MDX查询
     */
    @Override
    public String doQuery(Map params) throws IOException {
        return null;
    }

    /**
     * 读取系统Email配置信息
     */
    @Override
    public String getEmailConfig() throws IOException {
        Response response = get(getApiBase() + EmailResource.GET_EMAIL_CONFIG);
        EmailResource resource = new EmailResource(response);
        return resource.getEmailConfig();
    }

    /**
     * 读取文件或文件夹,文件名形如:home:admin
     */
    @Override
    public String getFileOrDir(String path) throws IOException {
        Response response = download(getApiBase() + FileResource.FILES + path);
        FileResource resource = new FileResource(response);
        return resource.getFileOrDir();
    }

    @Override
    public String getSchedulerJobs() throws IOException {
        Response response = get(getApiBase() + SchedulerResource.SCHEDULER_GET_JOBS);
        SchedulerResource resource = new SchedulerResource(response);
        return resource.getJobs();
    }


    /**
     * 读取用户列表
     */
    @Override
    public List<String> getUsers() throws IOException, DocumentException {
        Response response = get(getApiBase() + UserResource.LIST_USERS);
        UserResource resource = new UserResource(response);
        return resource.getUsers();
    }


    /**
     * 验证当前用户能否执行ActionResource操作。
     */
    @Override
    public boolean isActionAuthorized(String actionName) throws IOException {
        Response response = get(getApiBase() + ActionResource.IS_AUTHORIZED + actionName);
        ActionResource resource = new ActionResource(actionName, response);
        return resource.isAuthorized();
    }

    /**
     * 判断系统Email配置信息是否可用。
     */
    @Override
    public boolean isEmailConfigurationValid() throws IOException {
        Response response = get(getApiBase() + EmailResource.IS_VALID);
        EmailResource resource = new EmailResource(response);
        return resource.isValid();
    }


    private String getApiBase() {
        return super.getApiBase(PENTAHO_CONTEXT);
    }

    public static void main(String[] args) throws IOException, DocumentException {
        PentahoClient client = new PentahoClient();
        System.out.println(client.getUsers());
    }
}
