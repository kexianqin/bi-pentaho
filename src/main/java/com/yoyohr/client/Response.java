package com.yoyohr.client;

import java.io.InputStream;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class Response {
    private int code;
    private String data;

    public Response(int code, String data) {
        this.code = code;
        this.data = data;
    }

    public Response(int code, String data, InputStream inputStream) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "{\"code\":" + code + ",\"data\":\"" + data + "\"}";
    }
}
