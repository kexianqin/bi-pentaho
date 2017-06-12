package com.yoyohr.client;

import com.yoyohr.bi.bean.Result;
import com.yoyohr.client.resource.saiku.*;
import com.yoyohr.client.resource.saiku.bean.*;
import com.yoyohr.client.resource.saiku.query.Cell;
import com.yoyohr.client.resource.saiku.query.QueryResult;
import com.yoyohr.util.JsonUtil;
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
import java.util.ArrayList;
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
     * @throws IOException
     * @throws URISyntaxException
     */
    public SaikuClient() throws IOException, URISyntaxException, UnanthenticatedException {
        log.info("SaikuClient Constructing...");
        target = new HttpHost(SAIKU_HOST, 9090,SAIKU_PROTOCOL);//使用给定的协议，主机名和端口创建HttpHost实例,-1表示默认端口：http://pentaho.yoyohr.com
        cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom() // 即 new Httpclient()
            .setDefaultCookieStore(cookieStore).build(); //将CookieStore设置到httpClient中
//        httpClient= HttpClients.createDefault();
        context = HttpClientContext.create();// ????
        setCookies();//登录并获取session
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
        String queryJson = resource.constructQueryJson(cubeUniqueName, mdx);//得到POST的内容
        Response response = postJson(requestUri, queryJson);
        resource.setResponse(response);
        return resource.parseQueryResult();
    }

    public String executeSaikuQuery2 (String cubeUniqueName, String mdx) throws IOException {
        QueryResource resource = new QueryResource();
        String requestUri = getApiUri(resource.getUriOfExecuteQuery());
        String queryJson = resource.constructQueryJson(cubeUniqueName, mdx);//得到POST的内容
        Response response = postJson(requestUri, queryJson);
        resource.setResponse(response);
        return response.getData();
    }

    @Override
    public List<SaikuAdminDatasource> getAvailableAdminDataSources() throws IOException{
        AdminResource resource =new AdminResource();
        String requestUri=getApiUri(resource.getUriOfGetAvailableDataSources());
        Response response=get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuAdminDatasources();
    }

    @Override
    public List<SaikuAdminMondrianSchema> getAvailableAdminMondrianSchemas() throws IOException{
        AdminResource resource =new AdminResource();
        String requestUri=getApiUri(resource.getUriOfGetAvailableAdminMondrianSchemas());
        Response response=get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuAdminMondrianSchemas();
    }

    /**
       返回的是schema的内容(例如id=foodmart4.xml)
     */
    @Override
    public String getSavedSchema(String id) throws IOException{
        AdminResource resource = new AdminResource();
        String requestUri=getApiUri(resource.getUriOfGetSavedSchema(id));
        Response response=get(requestUri);
        resource.setResponse(response);
        return resource.getResponse().getData();
    }

    @Override
    public List<SaikuAdminUser> getExistingAdminUsers() throws IOException{
        AdminResource resource = new AdminResource();
        String requestUri=getApiUri(resource.getUriOfGetExistingAdminUsers());
        Response response=get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuAdminUsers();
    }

    @Override
    public SaikuAdminUser getUserDetails(int id) throws IOException{
        AdminResource resource = new AdminResource();
        String requestUri=getApiUri(resource.getUriOfGetUserDetails(id));
        Response response= get(requestUri);
        resource.setResponse(response);
        return resource.parseSaikuAdminUser();
    }

    public static void main(String[] args) throws UnanthenticatedException, IOException, URISyntaxException {
        String cubeUniqueName="[youpin_kdwh_srm].[youpin_kdwh_srm].[youpin_kdwh_srm].[youpin_kdwh_expense]";
        String mdx="WITH\n" +
            "SET [~ROWS] AS\n" +
            "    {[operator].[operator].[operator_key].Members}\n" +
            "SELECT\n" +
            "NON EMPTY {[Measures].[action_numbers]} ON COLUMNS,\n" +
            "NON EMPTY [~ROWS] ON ROWS\n" +
            "FROM [youpin_kdwh_expense]";
        String mdx1="with \n" +
            "  member [measures].[name] as  [operator].[operator_key].currentmember.properties(\"operator_name\")\n" +
            "  member [measures].[city] as [operator].[operator_key].currentmember.properties(\"operator_city\")\t\n" +
            "select\n" +
            " {[measures].[name],[measures].[city]} on columns,\n" +
            " Descendants([operator].[operator_enterprise_id].[300],[operator].[operator_key],self) on rows\n" +
            "from [youpin_kdwh_expense]";
        SaikuClient saikuClient =new SaikuClient();
        System.out.println(saikuClient.getAvailableAdminMondrianSchemas());
        System.out.println(saikuClient.getAvailableAdminDataSources());
//        List<Result> results=new ArrayList<>();
//        QueryResult queryResult=saikuClient.executeSaikuQuery(cubeUniqueName,mdx1);
//        List<Cell[]> cellset=queryResult.getCellset();
//        for(int i=0;i<cellset.size();i++){
//            Result result=new Result();
//            for(Cell cells:cellset.get(i)){
//                log.info(cells.getType());
//                log.info(cells.getValue());
//                if(cells.getType().equals(Cell.Type.ROW_HEADER.toString())){
//                    result.setName(cells.getValue());
//                }
//                if(cells.getType().equals(Cell.Type.DATA_CELL.toString())){
//                    result.setValue(Double.parseDouble(cells.getValue().replace(",","").trim()));
//                }
//            }
//            if(result.getName()!=null){
//                results.add(result);
//            }
//        }
//        System.out.println(JsonUtil.toJson(results));

//        SaikuClient saikuClient =new SaikuClient();
//
//        List<SaikuAdminMondrianSchema> list=saikuClient.getAvailableAdminMondrianSchemas();
//        for (SaikuAdminMondrianSchema MondrianSchema :list){
//            System.out.println(MondrianSchema.getName());
//        }
//
//        List<SaikuAdminDatasource> list1=saikuClient.getAvailableAdminDataSources();
//        for (SaikuAdminDatasource datasource :list1){
//            System.out.println(datasource.getConnectionname());
//        }
//
//        List<SaikuAdminUser> list2=saikuClient.getExistingAdminUsers();
//        for (SaikuAdminUser user : list2){
//            System.out.println(user.getUsername());
//        }
//
//        System.out.println(saikuClient.getSavedSchema("foodmart4.xml"));
//
//        System.out.println(saikuClient.getUserDetails(1).getUsername());
    }


    /**
     * 得到要访问的url地址，传入的endpoint为尾缀
     *
     * @param endpoint
     * @return
     */
    private String getApiUri(String endpoint) {
        String uri = getApiBase(SAIKU_CONTEXT) + BaseResource.REST_SAIKU + endpoint;// saiku 和后面的/rest/saiku为什么不放到一起
       log.debug("===========" + uri);    // https://pentaho.yoyohr.com/saiku/rest/saiku/+endpoint(例如saiku)
        return uri;
    }
}
