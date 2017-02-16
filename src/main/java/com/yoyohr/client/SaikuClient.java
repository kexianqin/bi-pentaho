package com.yoyohr.client;

import com.yoyohr.client.resource.saiku.BaseResource;
import com.yoyohr.client.resource.saiku.OlapDiscoverResource;
import com.yoyohr.client.resource.saiku.SessionResource;
import com.yoyohr.client.resource.saiku.bean.SaikuConnection;
import com.yoyohr.client.resource.saiku.bean.SaikuCube;
import com.yoyohr.client.resource.saiku.bean.SaikuCubeMetadata;
import com.yoyohr.client.resource.saiku.bean.SaikuSession;
import com.yoyohr.util.PropertiesReader;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SaikuClient extends BaseHttpClient implements ISaikuClient {

    private static final Logger log = LoggerFactory.getLogger(SaikuClient.class);

    private static final String SAIKU_PROTOCOL = PropertiesReader.getValue("saiku.protocol");
    private static final String SAIKU_HOST = PropertiesReader.getValue("saiku.host");
    private static final String SAIKU_USERNAME = PropertiesReader.getValue("saiku.user.name");
    private static final String SAIKU_PASSWORD = PropertiesReader.getValue("saiku.user.password");

    public static final String SAIKU_CONTEXT = PropertiesReader.getValue("saiku.context");

    private CookieStore cookieStore;

    private SaikuSession saikuSession;

    public SaikuClient() throws IOException, URISyntaxException, UnanthenticatedException {
        log.info("SaikuClient Constructing...");
        target = new HttpHost(SAIKU_HOST, -1, SAIKU_PROTOCOL);
        cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore).build();
        context = HttpClientContext.create();
        setCookies();
    }


    @Override
    public List<SaikuConnection> getRestOlapConnection(String connectionName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri(
                "/" + saikuSession.getUsername() + resource.getUriOfGetRestOlapConnection(connectionName)
        );
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseOlapConnections();

    }

    @Override
    public List<SaikuConnection> getRestOlapConnections() throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri(
                "/" + saikuSession.getUsername() + resource.getUriOfGetRestOlapConnections()
        );
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseOlapConnections();
    }

    @Override
    public SaikuCubeMetadata getRestSaikuCubeMetadata(SaikuCube saikuCube) throws IOException {
        return getRestSaikuCubeMetadata(saikuCube.getUniqueName());
    }

    @Override
    public SaikuCubeMetadata getRestSaikuCubeMetadata(String saikuCubeUniqueName) throws IOException {

        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri(
                "/" + saikuSession.getUsername() + resource.getUriOfGetRestCubeMetadata(saikuCubeUniqueName)
        );
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuCubeMetaData();
    }

    @Override
    public SaikuSession getRestSaikuSession() throws IOException {
        SessionResource resource = new SessionResource();
        Response response = get(getApiUri(resource.getUriOfGetRestSaikuSession()));
        resource.setResponse(response);
        return resource.parseSaikuSession();
    }

    @Override
    public List<SaikuConnection> refreshRestOlapConnection(String connectionName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri(
                "/" + saikuSession.getUsername() + resource.getUriOfRefreshRestOlapConnection(connectionName)
        );
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseOlapConnections();
    }

    @Override
    public List<SaikuConnection> refreshRestOlapConnections() throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri(
                "/" + saikuSession.getUsername() + resource.getUriOfRefreshRestOlapConnections()
        );
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseOlapConnections();
    }

    private void setCookies() throws IOException, URISyntaxException, UnanthenticatedException {
        String requestUri = getApiUri(SessionResource.SESSION);
        HashMap<String, String> params = new HashMap<>();
        params.put("username", SAIKU_USERNAME);
        params.put("password", SAIKU_PASSWORD);
        Response response = post(requestUri, params);
        if (response.getCode() == 0) {
            saikuSession = getRestSaikuSession();
        } else {
            throw new UnanthenticatedException("登录失败");
        }
    }

    private String getApiUri(String endpoint) {
        String uri = getApiBase(SAIKU_CONTEXT) + BaseResource.REST_SAIKU + endpoint;
        log.debug("===========" + uri);
        return uri;
    }

    public static void main(String[] args) throws IOException, URISyntaxException, UnanthenticatedException {
        SaikuClient client = new SaikuClient();
        String cubeUniqueName = "[youpin_dwh].[youpin_dwh].[youpin_dwh].[youpin_dwh]";
        log.info(client.getRestSaikuCubeMetadata(cubeUniqueName).toString());
    }
}
