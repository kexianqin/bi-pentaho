package com.yoyohr.client;

import com.yoyohr.util.PropertiesReader;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuClient extends BaseHttpClient implements ISaikuClient {

    private static final String SAIKU_PROTOCOL = PropertiesReader.getValue("saiku.protocol");
    private static final String SAIKU_HOST = PropertiesReader.getValue("saiku.host");
    private static final String SAIKU_PORT = PropertiesReader.getValue("saiku.port");
    private static final String SAIKU_USERNAME = PropertiesReader.getValue("saiku.user.name");
    private static final String SAIKU_PASSWORD = PropertiesReader.getValue("saiku.user.password");

    public SaikuClient() {
        super(SAIKU_PROTOCOL, SAIKU_HOST, Integer.parseInt(SAIKU_PORT), SAIKU_USERNAME, SAIKU_PASSWORD);
    }


}
