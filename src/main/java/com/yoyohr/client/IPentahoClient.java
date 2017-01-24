package com.yoyohr.client;

import java.util.ArrayList;

/**
 * 访问Pentaho BA服务
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public interface IPentahoClient {

    boolean canAdminister() throws Exception;

    String backupSystem() throws Exception;

    boolean createDir(String path) throws Exception;

    boolean deleteFiles(String files) throws Exception;

    boolean deleteFilesPermanent(String files) throws Exception;

    String getEmailConfig() throws Exception;

    String getFileOrDir(String path) throws Exception;

    String getSchedulerJobs() throws Exception;

    ArrayList<String> getUsers() throws Exception;

    boolean isActionAuthorized(String actionName) throws Exception;

    boolean isEmailConfigurationValid() throws Exception;





}
