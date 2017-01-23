package com.yoyohr.client.resource;

import com.yoyohr.client.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class FileResource extends Resource {

    public static final String FILES_BACKUP = "/repo/files/backup";

    public static final String SYSTEM_RESTORE = "/repo/files/systemRestore";

    public static final String FILES_DELETE = "/repo/files/delete";

    public static final String FILES_DELETE_PERMANENT = "/repo/files/deletepermanent";


    public FileResource(Response response) {
        super(response);
    }

    public String backup() throws IOException {

        return response.getData();
    }
}
