package com.yoyohr.client;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.yoyohr.util.PropertiesReader;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;


/**
 * Created by Administrator on 2017/6/12.
 */
public class PentahoClient extends BaseHttpClient implements IPentahoClient{
    private static final Logger log = LoggerFactory.getLogger(PentahoClient.class);


    private static final String PENTAHO_USERNAME = PropertiesReader.getValue("pentaho.user.name");
    private static final String PENTAHO_PASSWORD = PropertiesReader.getValue("pentaho.user.password");
    private static final String PENTAHO_PROTOCOL = PropertiesReader.getValue("pentaho.protocol");
    private static final String PENTAHO_HOST = PropertiesReader.getValue("pentaho.host");

    public static final String PENTAHO_CONTEXT = PropertiesReader.getValue("pentaho.context");

    public PentahoClient(){
        log.info("SaikuClient Constructing...");
        target = new HttpHost(PENTAHO_HOST, 9090,PENTAHO_PROTOCOL);
        httpClient = HttpClients.createDefault();
        context = HttpClientContext.create();
    }

    @Override
    public void isAuthenticated()throws IOException {
        String requestUri=getApiUri("/mantle/isAuthenticated");
        Response response = get(requestUri);
        if(response.getCode()==401){
            log.info("未认证");
        }
        if(response.getData().equals("true")){
            log.info("已认证");
        }
    }

    @Override
    public void addDirectory(String pathId) throws IOException {
        String requestUri = getApiUri("/repo/dirs/"+pathId);
        Response response = put(requestUri);
        if(response.getData().equals("couldNotCreateFolderDuplicate") && response.getCode()==409){
            log.info("该文件夹已存在");
        }
        if(response.getCode()==0){
            log.info("文件夹创建成功");
        }
    }

    @Override
    public void filesBackup() throws IOException{
        String requestUri = getApiUri("/repo/files/backup");
        Response response = getFile(requestUri);
        if(response.getCode()==0){
            log.info("备份成功,请查看桌面");
        }else if(response.getCode()==403){
            log.info("无管理员权限");
        }else{
            log.info("备份失败");
        }
    }

    @Override
    public void filesSystemRestore(String fileName) throws IOException{
        String requestUri= getApiUri("/repo/files/systemRestore");
        Response response = upload(requestUri,fileName);
        if(response.getCode()==0){
            log.info("备份成功,请查看桌面");
        }else if(response.getCode()==403){
            log.info("无管理员权限");
        }else{
            log.info("备份失败");
        }
    }



    /**
     * Generation the Authorization
     * @return eg:Basic QWRtaW46cGFzc3dvcmQ=
     */
    public static String generateAuthorizationToken(){
        String source = PENTAHO_USERNAME+":"+PENTAHO_PASSWORD;
        byte[] bytes =Base64.encodeBase64Chunked(source.getBytes());
        //该方法后面自带有\r\n,故需要去除
        return "Basic "+ new String(bytes).replace("\r","").replace("\n","");
    }

    private String getApiUri(String endpoint) {
        String uri = getApiBase(PENTAHO_CONTEXT) +"/api"+ endpoint;
        log.debug("===========" + uri);
        return uri;
    }


    public static void main(String[] args) throws UnanthenticatedException, IOException, URISyntaxException {
        PentahoClient pentahoclient =new PentahoClient();
//        pentahoclient.addDirectory("");
//        pentahoclient.filesBackup();
        pentahoclient.filesSystemRestore("C:/Users/Administrator/Desktop/SystemBackup.zip");
    }
}


