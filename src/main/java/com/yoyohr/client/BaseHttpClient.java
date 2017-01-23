package com.yoyohr.client;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class BaseHttpClient {

    public static final String DEFAULT_CHARSET = "UTF-8";

    public static final String APPLICATION_JSON_UTF8 = "application/json;charset=UTF-8";
    public static final String APPLICATION_XML = "application/xml";
    public static final String TEXT_PLAIN = "text/plain";

    protected HttpHost target;
    protected CloseableHttpClient httpClient;
    protected HttpClientContext context;

    public BaseHttpClient(String protocol, String host, int port, String username, String password) {
        target = new HttpHost(host, port, protocol);

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(username, password));
        httpClient = HttpClients.custom().setDefaultCredentialsProvider(credentialsProvider).build();

        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(target, basicAuth);
        context = HttpClientContext.create();
        context.setAuthCache(authCache);
    }

    public Response get(String url) throws Exception {
        return get(url, null);
    }

    public Response get(String url, String mediaType) throws Exception {
        HttpUriRequest request = new HttpGet(url);
        if (mediaType != null) {
            request.setHeader("Accept", mediaType);
        }
        return httpClient.execute(
                target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }

    public Response download(String url) throws Exception {
        HttpUriRequest request = new HttpGet(url);
        return httpClient.execute(
                target, request, (HttpResponse response) -> handleResponseAsStream(response), context);
    }

    public Response post(String url, String mediaType) throws Exception {
        HttpUriRequest request = new HttpPost(url);

        return httpClient.execute(
                target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }

    public Response put(String url) throws Exception {
        HttpUriRequest request = new HttpPut(url);
        return httpClient.execute(
                target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }

    public Response delete(String url) throws Exception {
        HttpUriRequest request = new HttpDelete(url);
        return this.httpClient.execute(
                target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }


    public void close() throws IOException {
        httpClient.close();
    }

    private Response handleResponseAsString(HttpResponse response) throws IOException {
        int status = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        return new Response(
                status >= 200 && status < 400 ? 0 : status,
                entity != null ? EntityUtils.toString(entity, DEFAULT_CHARSET) : null
        );
    }


    private Response handleResponseAsStream(HttpResponse response) throws IOException {
        int status = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        if (status >= 200 && status < 400) {
            InputStream inputStream = entity.getContent();
            String fileName = "data/SystemBackup.zip";
            if (inputStream != null) {

                File file = new File(fileName);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                /**
                 * 根据实际运行效果 设置缓冲区大小
                 */
                byte[] buffer = new byte[2048];
                int ch = 0;
                while ((ch = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, ch);
                }
                inputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            return new Response(0, fileName);
        } else {
            return new Response(
                    status >= 200 && status < 400 ? 0 : status,
                    entity != null ? EntityUtils.toString(entity, DEFAULT_CHARSET) : null
            );
        }

    }

    public static void main(String[] args) throws Exception {
        BaseHttpClient client = new BaseHttpClient(
                "http", "192.168.1.125", 8080, "admin", "password");
        System.out.println(client.get("http://192.168.1.125:8080/pentaho/api/users").toString());
        client.close();
    }

}
