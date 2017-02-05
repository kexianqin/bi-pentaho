package com.yoyohr.client;

import org.apache.http.*;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;


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

    public Response get(String url) throws IOException {
        return get(url, null, null);
    }

    public Response get(String url, Map<String, String> params) throws IOException {
        return get(url, params, null);
    }

    public Response get(String url, Map<String, String> params, String mediaType) throws IOException {
        HttpUriRequest request = new HttpGet(url);
        if (mediaType != null) {
            request.setHeader("Accept", mediaType);
        }
        return httpClient.execute(
                target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }

    public Response download(String url) throws IOException {
        return download(url, null);
    }

    public Response download(String url, Map<String, String> params) throws IOException {
        HttpUriRequest request = new HttpGet(url);
        return httpClient.execute(
                target, request, (HttpResponse response) -> handleResponseAsStream(response), context);
    }

    public Response post(String url) throws Exception {
        return post(url, null, null);
    }

    public Response post(String url, Map<String, String> params) throws Exception {

        return post(url, params, null);
    }

    public Response post(String url, Map<String, String> params, String mediaType) throws IOException {
        HttpUriRequest request = new HttpPost(url);
        if (mediaType != null) {
            request.setHeader("Accept", mediaType);
        }
        return httpClient.execute(
                target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }

    public Response put(String url) throws IOException {
        return put(url, null);
    }

    public Response put(String url, Map<String, String> params) throws IOException {
        HttpPut request = new HttpPut(url);
        if (params != null) {
            ArrayList<NameValuePair> nvps = new ArrayList<>();
            params.forEach((String key, String value) ->
                    nvps.add(new BasicNameValuePair(key, value))
            );
            request.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
        }

        return httpClient.execute(
                target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }

    public Response delete(String url, Map<String, String> params) throws IOException {
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
            String fileName = getFileName(response);
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

    private String getFileName(HttpResponse response) {
        Header contentDispositionHeader = response.getFirstHeader("Content-Disposition");
        String filename = null;
        if (contentDispositionHeader != null) {
            HeaderElement[] values = contentDispositionHeader.getElements();
            if (values.length == 1) {
                NameValuePair param = values[0].getParameterByName("filename");
                if (param != null) {
                    filename = param.getValue();
                }
            }
        }
        return filename;
    }

}
