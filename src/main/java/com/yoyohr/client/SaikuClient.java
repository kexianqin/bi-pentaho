package com.yoyohr.client;

import com.yoyohr.client.resource.saiku.BaseResource;
import com.yoyohr.client.resource.saiku.OlapMetadataResource;
import com.yoyohr.client.resource.saiku.OlapDiscoverResource;
import com.yoyohr.client.resource.saiku.QueryResource;
import com.yoyohr.client.resource.saiku.SessionResource;
import com.yoyohr.client.resource.saiku.bean.*;
import com.yoyohr.client.resource.saiku.query.QueryResult;
import com.yoyohr.util.PropertiesReader;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
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

    /**
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public SaikuClient() throws IOException, URISyntaxException, UnanthenticatedException {
        log.info("SaikuClient Constructing...");
        target = new HttpHost(SAIKU_HOST, -1, SAIKU_PROTOCOL);//使用给定的协议，主机名和端口创建HttpHost实例,-1表示默认端口：http://pentaho.yoyohr.com
        cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom() // 即 new Httpclient()
                .setDefaultCookieStore(cookieStore).build(); //将CookieStore设置到httpClient中
//        httpClient= HttpClients.createDefault();
        context = HttpClientContext.create();// ????
        setCookies();//登录
    }

    @Override
    public SaikuSession getRestSaikuSession() throws IOException {
        SessionResource resource = new SessionResource();
        Response response = get(getApiUri(resource.getUriOfGetRestSaikuSession()));
        resource.setResponse(response);
        return resource.parseSaikuSession();
    }

    @Override
    public List<SaikuConnection> getRestOlapConnections() throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestOlapConnections());
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuConnections();
    }

    @Override
    public List<SaikuConnection> refreshRestOlapConnections() throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfRefreshRestOlapConnections());
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuConnections();
    }

    @Override
    public List<SaikuConnection> getRestOlapConnection(String connectionName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestOlapConnection(connectionName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuConnections();

    }

    @Override
    public List<SaikuConnection> refreshRestOlapConnection(String connectionName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfRefreshRestOlapConnection(connectionName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuConnections();
    }

    @Override
    public SaikuCubeMetadata getRestSaikuCubeMetadata(String saikuCubeUniqueName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestCubeMetadata(saikuCubeUniqueName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuCubeMetaData();
    }

    @Override
    public List<SaikuDimension> getRestSaikuDimensions(String saikuCubeUniqueName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestSaikuDimensions(saikuCubeUniqueName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuDimensions();
    }

    @Override
    public SaikuDimension getRestSaikuDimension(String saikuCubeUniqueName, String dimensionName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestSaikuDimension(saikuCubeUniqueName, dimensionName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuDimension();
    }

    @Override
    public List<SaikuHierarchy> getRestSaikuDimensionHierarchies(String saikuCubeUniqueName,
                                                                 String dimensionName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestSaikuDimensionHierarchies(saikuCubeUniqueName, dimensionName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuHierarchies();
    }

    @Override
    public List<SaikuLevel> getRestSaikuDimensionHierarchy(String saikuCubeUniqueName,
                                                           String dimensionName,
                                                           String hieraychyName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestSaikuDimensionHierarchy(saikuCubeUniqueName, dimensionName, hieraychyName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuLevels();
    }

//    @Override
//    public SaikuDimensionAndMeasure getRestOlapDimensions(String saikuCubeUniqueName) throws IOException {
//        OlapDiscoverResource resource = new OlapDiscoverResource();
//        String requestUri = getApiUri("/" + saikuSession.getUsername()
//            + resource.getUriOfGetRestSaikuDimensions(saikuCubeUniqueName));
//        Response response = get(requestUri);
//        resource.setResponse(response);
//        return resource.parseSaikuDimensions();
//        Response response = get(getApiUri(saikuSession.getUsername()+"/"+OlapDiscoverResource.OLAP_DISCOVER+"/"+
//                "youpin_dwh/youpin_dwh/youpin_dwh/youpin_dwh/"+ OlapMetadataResource.OLAP_METADATA));
//        OlapMetadataResource resource =new OlapMetadataResource(response);
//        return resource.getRestOlapDimensionsAndMeasure();
//    }

//    private void setCookies() throws IOException, URISyntaxException {

//        HttpUriRequest login = RequestBuilder.post()
//                .setUri(new URI(getApiUri(SessionResource.SESSION)))
//                .addParameter("username", SAIKU_USERNAME)
//                .addParameter("password", SAIKU_PASSWORD)
//                .build();
        //HttpUriRequest:HttpRequest接口的扩展版本，提供方便的方法来访问请求属性，如请求URI和方法类型。 RequestBuilder:HttpUriRequest实例的构建器。
//        HttpUriRequest login = RequestBuilder.post()
//                .setUri(new URI(getApiUri(SessionResource.SESSION)))
//                .addParameters(new BasicNameValuePair("username", SAIKU_USERNAME), new BasicNameValuePair("password", SAIKU_PASSWORD))
//                .build();
//        httpClient.execute(login);
//        saikuSession = getRestSaikuSession();
    public List<SimpleCubeElement> getRestSaikuLevelMembers(String saikuCubeUniqueName,
                                                            String dimensionName,
                                                            String hierarchyName,
                                                            String levelName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestSaikuLevelMembers(saikuCubeUniqueName, dimensionName, hierarchyName, levelName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuLevelMembers();
    }

    @Override
    public List<SaikuMember> getRestSaikuRootMembers(String saikuCubeUniqueName,
                                                     String hierarchyName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestSaikuRootMembers(saikuCubeUniqueName, hierarchyName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuMembers();
    }

    @Override
    public List<SaikuHierarchy> getRestSaikuCubeHierarchies(String saikuCubeUniqueName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestSaikuCubeHierarchies(saikuCubeUniqueName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuHierarchies();
    }

    @Override
    public List<SaikuMeasure> getRestSaikuCubeMeasures(String saikuCubeUniqueName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestSaikuCubeMeasures(saikuCubeUniqueName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuMeasures();
    }

    @Override
    public SaikuMember getRestSaikuMember(String saikuCubeUniqueName, String memberName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestSaikuMember(saikuCubeUniqueName, memberName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuMember();
    }

    @Override
    public List<SaikuMember> getRestSaikuMemberChildren(String saikuCubeUniqueName,
                                                        String memberName) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
        String requestUri = getApiUri("/" + saikuSession.getUsername()
            + resource.getUriOfGetRestSaikuMemberChildren(saikuCubeUniqueName, memberName));
        Response response = get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuMembers();
    }

    @Override
    public QueryResult executeSaikuQuery(String cubeUniqueName, String mdx) throws IOException {
        QueryResource resource = new QueryResource();
        String requestUri = getApiUri(resource.getUriOfExecuteQuery());
        String queryJson = resource.constructQueryJson(cubeUniqueName, mdx);
        Response response = postJson(requestUri, queryJson);
        resource.setResponse(response);
        return resource.parseQueryResult();
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

    public String executeQuery() throws IOException {
        String jsonString =
            "{\"name\":\"ADCD8856-C485-FDD8-99DA-3325133D49E4\",\"queryModel\":{},\"queryType\":\"OLAP\",\"type\":\"MDX\",\"cube\":{\"uniqueName\":\"[youpin_dwh].[youpin_dwh].[youpin_dwh].[youpin_dwh]\",\"name\":\"youpin_dwh\",\"connection\":\"youpin_dwh\",\"catalog\":\"youpin_dwh\",\"schema\":\"youpin_dwh\",\"caption\":null,\"visible\":false},\"mdx\":\"WITH\\r\\nSET [~ROWS] AS\\r\\n    {[operator].[operator].[operator_name].Members}\\r\\nSELECT\\r\\nNON EMPTY {[Measures].[action_key]} ON COLUMNS,\\r\\nNON EMPTY [~ROWS] ON ROWS\\r\\nFROM [youpin_dwh]\",\"parameters\":{},\"plugins\":{},\"properties\":{\"saiku.olap.query.automatic_execution\":true,\"saiku.olap.query.nonempty\":true,\"saiku.olap.query.nonempty.rows\":true,\"saiku.olap.query.nonempty.columns\":true,\"saiku.ui.render.mode\":\"table\",\"saiku.olap.query.filter\":true,\"saiku.olap.result.formatter\":\"flat\",\"org.saiku.query.explain\":true,\"saiku.olap.query.drillthrough\":true,\"org.saiku.connection.scenario\":false},\"metadata\":{}}";
        String requestUri = "https://pentaho.yoyohr.com/saiku/rest/saiku/api/query/execute";
        Response reponse = postJson(requestUri, jsonString);
        return reponse.getData();
    }

    /**
     * 得到要访问的url地址，传入的endpoint为尾缀
     * @param endpoint
     * @return
     */
    private String getApiUri(String endpoint) {
        String uri = getApiBase(SAIKU_CONTEXT) + BaseResource.REST_SAIKU + endpoint;// saiku 和后面的/rest/saiku为什么不放到一起？？？
        log.debug("===========" + uri);    // https://pentaho.yoyohr.com/saiku/rest/saiku/+endpoint(例如saiku)
        return uri;
    }

//    public static void main(String[] args) throws IOException, URISyntaxException, UnanthenticatedException {
//        SaikuClient client = new SaikuClient();
//        log.info(client.getRestOlapConnections().toString());
//        log.info(client.getRestOlapDimensions().toString());
//        log.info("ok");
//    }

}
