package com.yoyohr.bi.web.auth;

import com.yoyohr.client.BaseHttpClient;
import com.yoyohr.client.Response;
import com.yoyohr.client.SaikuClient;
import com.yoyohr.util.PropertiesReader;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.PropertyPermission;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class AuthClient extends BaseHttpClient {

    private static final Logger log = LoggerFactory.getLogger(SaikuClient.class);

    private static final String AUTH_HOST= PropertiesReader.getValue("auth.host");
    private static final String AUTH_PROTOCOL=PropertiesReader.getValue("auth.protocol");

    public AuthClient()throws Exception{
        target=new HttpHost(AUTH_HOST,-1,AUTH_PROTOCOL);
        httpClient= HttpClients.createDefault();
        context = HttpClientContext.create();
    }
    /**
     * @return  true 代表验证通过
     *           false 代表验证失败
     * @throws Exception
     */
    public boolean whetherThereIsPermission(String auth) throws Exception {
        AuthResource authResource =new AuthResource();
        String requestUri=getApiBase(authResource.getUriOfWhetherThereIsPermission());
        HashMap<String, String> params = new HashMap<>();
        params.put("token",auth);
        Response response=get(requestUri,params);
        authResource.setResponse(response);
        //System.out.println(response.getData());
        return authResource.determineAuth();
    }

//    public static void main(String[] args) throws Exception {
//        AuthClient a =new AuthClient();
//        boolean b=a.WhetherThereIsPermission("");
//        System.out.println(b);
//    }



}
