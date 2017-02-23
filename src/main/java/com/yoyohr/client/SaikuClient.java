package com.yoyohr.client;

import com.yoyohr.client.resource.saiku.BaseResource;
import com.yoyohr.client.resource.saiku.OlapMetadataResource;
import com.yoyohr.client.resource.saiku.OlapDiscoverResource;
import com.yoyohr.client.resource.saiku.SessionResource;
import com.yoyohr.client.resource.saiku.bean.SaikuConnection;
import com.yoyohr.client.resource.saiku.bean.SaikuDimensionAndMeasure;
import com.yoyohr.client.resource.saiku.bean.SaikuSession;
import com.yoyohr.util.PropertiesReader;
import org.apache.http.HttpHost;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
    public SaikuClient() throws IOException, URISyntaxException {
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
    public List<SaikuConnection> getRestOlapConnections() throws IOException {
        Response response = get(getApiUri(saikuSession.getUsername() + "/" + OlapDiscoverResource.OLAP_DISCOVER));
        OlapDiscoverResource resource = new OlapDiscoverResource(response);
        return resource.getRestOlapConnections();
    }

    @Override
    public SaikuSession getRestSaikuSession() throws IOException {
        Response response = get(getApiUri(SessionResource.SESSION));
        SessionResource resource = new SessionResource(response);
        log.info(resource.getResponse().getData());
        return resource.getRestSaikuSession();
    }

    @Override
    public SaikuDimensionAndMeasure getRestOlapDimensions() throws IOException {
        Response response = get(getApiUri(saikuSession.getUsername()+"/"+OlapDiscoverResource.OLAP_DISCOVER+"/"+
                "youpin_dwh/youpin_dwh/youpin_dwh/youpin_dwh/"+ OlapMetadataResource.OLAP_METADATA));
        OlapMetadataResource resource =new OlapMetadataResource(response);
        return resource.getRestOlapDimensionsAndMeasure();
    }

    private void setCookies() throws IOException, URISyntaxException {

//        HttpUriRequest login = RequestBuilder.post()
//                .setUri(new URI(getApiUri(SessionResource.SESSION)))
//                .addParameter("username", SAIKU_USERNAME)
//                .addParameter("password", SAIKU_PASSWORD)
//                .build();
        //HttpUriRequest:HttpRequest接口的扩展版本，提供方便的方法来访问请求属性，如请求URI和方法类型。 RequestBuilder:HttpUriRequest实例的构建器。
        HttpUriRequest login = RequestBuilder.post()
                .setUri(new URI(getApiUri(SessionResource.SESSION)))
                .addParameters(new BasicNameValuePair("username", SAIKU_USERNAME), new BasicNameValuePair("password", SAIKU_PASSWORD))
                .build();
        httpClient.execute(login);
        saikuSession = getRestSaikuSession();
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

    public static void main(String[] args) throws IOException, URISyntaxException {
        SaikuClient client = new SaikuClient();
        log.info(client.getRestOlapConnections().toString());
        log.info(client.getRestOlapDimensions().toString());
        log.info("ok");
    }
}
