package com.yoyohr.client;

import com.yoyohr.client.resource.saiku.SessionResource;
import com.yoyohr.client.resource.saiku.bean.Session;
import com.yoyohr.util.PropertiesReader;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuClient extends BaseHttpClient implements ISaikuClient {

    private static final Logger logger = LoggerFactory.getLogger(SaikuClient.class);

    private static final String SAIKU_PROTOCOL = PropertiesReader.getValue("saiku.protocol");
    private static final String SAIKU_HOST = PropertiesReader.getValue("saiku.host");
    private static final String SAIKU_USERNAME = PropertiesReader.getValue("saiku.user.name");
    private static final String SAIKU_PASSWORD = PropertiesReader.getValue("saiku.user.password");

    public static final String SAIKU_CONTEXT = PropertiesReader.getValue("saiku.context");

    private static CookieStore cookieStore;

    public SaikuClient() throws IOException, URISyntaxException {
        logger.info("SaikuClient Constructing...");
        target = new HttpHost(SAIKU_HOST, -1, SAIKU_PROTOCOL);
        cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore).build();
        context = HttpClientContext.create();
        setCookies();
    }


    @Override
    public Session getRestSaikuSession() throws IOException {
        Response response = get(getApiBase() + SessionResource.REST_SAIKU_SESSION);
        SessionResource resource = new SessionResource(response);
        logger.info(resource.getResponse().getData());
        return resource.getRestSaikuSession();
    }

    private void setCookies() throws IOException, URISyntaxException {
        HttpUriRequest login = RequestBuilder.post()
                .setUri(new URI(getApiBase() + SessionResource.REST_SAIKU_SESSION))
                .addParameter("username", SAIKU_USERNAME)
                .addParameter("password", SAIKU_PASSWORD)
                .build();
        httpClient.execute(login);
    }

    private String getApiBase() {
        return super.getApiBase(SAIKU_CONTEXT);
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        SaikuClient client = new SaikuClient();
        client.getRestSaikuSession();
    }
}
