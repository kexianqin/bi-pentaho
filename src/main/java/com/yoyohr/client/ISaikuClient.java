package com.yoyohr.client;

import com.yoyohr.client.resource.saiku.bean.Session;

import java.io.IOException;

/**
 * 访问Saiku Server的客户端
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public interface ISaikuClient {

    Session getRestSaikuSession() throws IOException;

}
