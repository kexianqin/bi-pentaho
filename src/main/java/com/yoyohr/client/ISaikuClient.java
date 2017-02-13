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

    List<SaikuConnection> getRestOlapConnections() throws IOException;

    SaikuSession getRestSaikuSession() throws IOException;

}
