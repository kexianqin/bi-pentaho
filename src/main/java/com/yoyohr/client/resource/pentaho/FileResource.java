package com.yoyohr.client.resource.pentaho;

import com.yoyohr.client.Response;
import com.yoyohr.client.resource.Resource;

import java.io.IOException;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class FileResource extends Resource {

    public static final String FILES = "/api/repo/files/";

    public static final String FILES_CAN_ADMINISTER = FILES + "canAdminister";

    public static final String FILES_BACKUP = FILES + "backup";

    public static final String FILES_SYSTEM_RESTORE = FILES + "systemRestore";

    public static final String FILES_DELETE = FILES + "delete";

    public static final String FILES_DELETE_PERMANENT = FILES + "deletepermanent";

    public static final String FILES_PROPERTIES = FILES + "properties";


    public FileResource(Response response) {
        super(response);
    }

    public boolean canAdminister() {
        return "true".equalsIgnoreCase(response.getData()) ? true : false;
    }

    public String backup() throws IOException {

        return response.getData();
    }

    public boolean delete() {

        return true;
    }

    public boolean deletePermanent() {
        return true;
    }

    public String getFileOrDir() {
        return response.getData();
    }


}
