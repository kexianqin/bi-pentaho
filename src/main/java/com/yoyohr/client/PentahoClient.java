package com.yoyohr.client;

import org.apache.commons.codec.binary.Base64;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class PentahoClient {

    private String username = "admin";
    private String password = "password";

    public String generateAuthorizationToken() {
        String source = username + ":" + password;

        byte[] bytes = Base64.encodeBase64Chunked(source.getBytes());
        return "Basic " + new String(bytes);
    }

    public static void main(String[] args) {
        PentahoClient client = new PentahoClient();
        System.out.println(client.generateAuthorizationToken());
    }
}
