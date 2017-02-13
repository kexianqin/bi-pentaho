package com.yoyohr.client;

import com.yoyohr.client.resource.saiku.bean.SaikuConnection;
import com.yoyohr.client.resource.saiku.bean.SaikuSession;

import java.io.IOException;
import java.util.List;

/**
 * 访问Saiku Server的客户端
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public interface ISaikuClient {

    /**
     *  访问https://https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover
     * @return
     * @throws IOException
     */
    List<SaikuConnection> getRestOlapConnections() throws IOException;

    /**
     *  访问https://pentaho.yoyohr.com/saiku/rest/saiku/session
     * @return
     * @throws IOException
     */
    SaikuSession getRestSaikuSession() throws IOException;


}
