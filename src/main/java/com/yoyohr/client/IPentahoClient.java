package com.yoyohr.client;

import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.List;

/**
 * 访问Pentaho BA服务
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public interface IPentahoClient {

    boolean canAdminister() throws IOException;

    String backupSystem() throws IOException;

    boolean createDir(String path) throws IOException;

    boolean deleteFiles(String files) throws IOException;

    boolean deleteFilesPermanent(String files) throws IOException;

    String getEmailConfig() throws IOException;

    String getFileOrDir(String path) throws IOException;

    String getSchedulerJobs() throws IOException;

    List<String> getUsers() throws IOException, DocumentException;

    boolean isActionAuthorized(String actionName) throws IOException;

    boolean isEmailConfigurationValid() throws IOException;





}
