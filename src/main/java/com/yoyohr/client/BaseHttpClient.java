package com.yoyohr.client;

import org.apache.http.*;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;

import org.apache.http.HttpEntity;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static com.yoyohr.client.PentahoClient.generateAuthorizationToken;


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

    public Response get(String url) throws IOException {
        return get(url, null, null);
    }
    public Response get(String url, Map<String, String> params) throws IOException {
        return get(url, params, null);
    }
    public Response get(String url, Map<String, String> params, String mediaType) throws IOException {
        String requestUri = url;
        if (params != null) {
            ArrayList<NameValuePair> nvps = new ArrayList<>();
            params.forEach(
                (String key, String value) -> nvps.add(new BasicNameValuePair(key, value))
            );
            requestUri = url + "?" + EntityUtils.toString(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
        }
        HttpGet request = new HttpGet(requestUri);
        /**
         * 基本认证
         */
        request.addHeader("Authorization", generateAuthorizationToken());
        if (mediaType != null) {
            request.setHeader("Accept", mediaType);
        }
        return httpClient.execute(
            target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }


    /**
     * 用于以get下载文件
     */
    public Response getFile(String url) throws IOException {
        return getFile(url, null, null);
    }
    public Response getFile(String url, Map<String, String> params) throws IOException {
        return getFile(url, params, null);
    }
    public Response getFile(String url, Map<String, String> params, String mediaType) throws IOException {
        String requestUri = url;
        if (params != null) {
            ArrayList<NameValuePair> nvps = new ArrayList<>();
            params.forEach(
                (String key, String value) -> nvps.add(new BasicNameValuePair(key, value))
            );
            requestUri = url + "?" + EntityUtils.toString(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
        }
        HttpGet request = new HttpGet(requestUri);
        /**
         * 基本认证
         */
        request.addHeader("Authorization", generateAuthorizationToken());
        if (mediaType != null) {
            request.setHeader("Accept", mediaType);
        }
        return httpClient.execute(
            target, request, (HttpResponse response) -> handleResponseAsStream(response), context);
    }


    public Response download(String url) throws IOException {
        return download(url, null);
    }
    public Response download(String url, Map<String, String> params) throws IOException {
        String requestUri = url;
        if (params != null) {
            ArrayList<NameValuePair> nvps = new ArrayList<>();
            params.forEach(
                (String key, String value) -> nvps.add(new BasicNameValuePair(key, value))
            );
            requestUri = url + "?" + EntityUtils.toString(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
        }
        HttpGet request = new HttpGet(requestUri);
        return httpClient.execute(
            target, request, (HttpResponse response) -> handleResponseAsStream(response), context);
    }


    public Response post(String url) throws IOException {
        return post(url, null, null);
    }
    public Response post(String url, Map<String, String> params) throws IOException {
        return post(url, params, null);
    }
    public Response post(String url, Map<String, String> params, String mediaType) throws IOException {
        HttpPost request = new HttpPost(url);
        if (params != null) {
            ArrayList<NameValuePair> nvps = new ArrayList<>();
            params.forEach((String key, String value) ->
                nvps.add(new BasicNameValuePair(key, value))
            );
            request.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
        }
        if (mediaType != null) {
            request.setHeader("Accept", mediaType);
        }
        return httpClient.execute(
            target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }


    /**
     * 用于上传文件(post方式)
     * @param url
     * @param filename (绝对路径)
     * @return
     * @throws IOException
     */
    public Response upload(String url, String filename, Map<String, String> formData) throws IOException {
        HttpPost request = new HttpPost(url);
        //request.setHeader("Accept", APPLICATION_XML);-->若设置成APPLICATION_XML,则importFile()将失败.404 Not Acceptable.
        request.addHeader("Authorization", generateAuthorizationToken());
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        if(formData!=null){
            formData.forEach((String key,String value)-> multipartEntityBuilder.addTextBody(key,value));
        }
        HttpEntity httpEntity = multipartEntityBuilder
            .addPart("fileUpload",new FileBody(new File(filename)))
            //.addTextBody("overwrite","true") //用作添加text形式的parameter.
            .setContentType(ContentType.MULTIPART_FORM_DATA).build();
        request.setEntity(httpEntity);
        return httpClient.execute(
            target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }


    public Response postJson(String url, String jsonString) throws IOException {
        HttpPost request = new HttpPost(url);
        request.setHeader("Accept", APPLICATION_JSON_UTF8);
        request.setEntity(new StringEntity(jsonString, ContentType.APPLICATION_JSON));
        return httpClient.execute(
            target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }


    public Response put(String url) throws IOException {
        return put(url, null,null,null);
    }
    public Response put(String url,String stringEntity) throws IOException {
        return put(url, null,stringEntity,null);
    }
    public Response put(String url,Map<String, String> params) throws IOException {
        return put(url,  params,null,null);
    }
    public Response put(String url, Map<String, String> params,String stringEntity,String contentType) throws IOException {
        HttpPut request = new HttpPut(url);
        /**
         * 基本认证
         */
        request.addHeader("Authorization", generateAuthorizationToken());
        //request.addHeader("Authorization","Basic QWRtaW46cGFzc3dvcmQ=");
        if (params != null) {
            ArrayList<NameValuePair> nvps = new ArrayList<>();
            params.forEach(
                (String key, String value) -> nvps.add(new BasicNameValuePair(key, value))
            );
            request.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
        }
        if(stringEntity != null){
            StringEntity entity = new StringEntity(stringEntity,DEFAULT_CHARSET);
            if(contentType!=null){
                entity.setContentType(contentType);
            }
            request.setEntity(entity);
        }
        return httpClient.execute(
            target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }
    /**
     *以put方式上传文件
     * @param fileKey 以form-data形式上传文件的key值
     * @param filename 上传文件的绝对路径,也就是value值
     * @param formData 一些其他的form-data
     */
    public Response putUpload(String url, String fileKey,String filename, Map<String, String> formData) throws IOException {
        HttpPut request = new HttpPut(url);
        request.addHeader("Authorization", generateAuthorizationToken());
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        if(formData!=null){
            formData.forEach((String key,String value)-> multipartEntityBuilder.addTextBody(key,value));
        }
        HttpEntity httpEntity = multipartEntityBuilder
            .addPart(fileKey,new FileBody(new File(filename)))
            .setContentType(ContentType.MULTIPART_FORM_DATA).build();
        request.setEntity(httpEntity);
        return httpClient.execute(
            target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }





    public Response delete(String url) throws IOException {
        String requestUri = url;
        HttpDelete request = new HttpDelete(requestUri);
        /**
         * 基本认证
         */
        request.addHeader("Authorization", generateAuthorizationToken());
        return httpClient.execute(
            target, request, (HttpResponse response) -> handleResponseAsString(response), context);
    }




    public void close() throws IOException {
        httpClient.close();
    }

    private Response handleResponseAsString(HttpResponse response)  throws IOException {
        int status = response.getStatusLine().getStatusCode();
        HttpEntity entity = response.getEntity();
        return new Response(
           //2017-06-22将条件 status<400改到201,因为发现存在status=204,No Content的情况
            status >= 200 && status < 201 ? 0 : status,
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
                /**
                 *  下载到桌面
                 */
                File file = new File("C:/Users/Administrator/Desktop/" + fileName);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                /**
                 * 根据实际运行效果 设置缓冲区大小
                 */
                byte[] buffer = new byte[2048];
                int ch;
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
                status >= 200 && status < 201 ? 0 : status,
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

    protected String getApiBase(String context) {
        return this.target.toURI() + "/" + context;
    }

}
