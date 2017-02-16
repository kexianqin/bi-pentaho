package com.yoyohr.client;

import com.yoyohr.client.resource.saiku.bean.SaikuConnection;
import com.yoyohr.client.resource.saiku.bean.SaikuCube;
import com.yoyohr.client.resource.saiku.bean.SaikuCubeMetadata;
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
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}
     */
    List<SaikuConnection> getRestOlapConnection(String connectionName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover
     */
    List<SaikuConnection> getRestOlapConnections() throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube}/metadata
     */
    SaikuCubeMetadata getRestSaikuCubeMetadata(SaikuCube saikuCube) throws IOException;

    SaikuCubeMetadata getRestSaikuCubeMetadata(String saikuCubeUniqueName) throws IOException;


    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/session
     */
    SaikuSession getRestSaikuSession() throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/refresh
     */
    List<SaikuConnection> refreshRestOlapConnection(String connectionName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/refresh
     */
    List<SaikuConnection> refreshRestOlapConnections() throws IOException;


}
