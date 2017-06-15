package com.yoyohr.client;

import java.io.IOException;

/**
 * 访问 pentaho 客户端
 *  Created by kexianqin on 2017/6/14.
 */
public interface IPentahoClient {

    /**
     * http://192.168.1.124:9090/pentaho/api /mantle/isAuthenticated
     * 功能:认证登录信息是否正确
     */
    void isAuthenticated() throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/dirs/{pathId}
     * 功能:创建文件夹
     * 注:{pathId}的书写方式应该为 :path:to:file,例如 home:ke
     */
    void addDirectory(String pathId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/backup
     * 功能:所有文件备份(地址设置在桌面)
     */
    void filesBackup() throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/systemRestore
     *功能:文件还原(利用备份文件的绝对路径)
     */
    void filesSystemRestore(String fileName) throws IOException;
}


