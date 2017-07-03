package com.yoyohr.client.resource.pentaho;

import com.yoyohr.client.PentahoClient;
import com.yoyohr.client.resource.pentaho.query.*;
import com.yoyohr.util.JsonUtil;
import com.yoyohr.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Administrator on 2017/6/29.
 */
public class QueryResource  extends BaseResource {

    private static final Logger log = LoggerFactory.getLogger(QueryResource.class);

    public OlapCubes parseOlapCubes() throws IOException{
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(),OlapCubes.class);
    }
    public OlapCubeStructure parseOlapCubeStructure() throws IOException{
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(),OlapCubeStructure.class);
    }
    public QueryResult parseQueryResult () throws IOException{
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(),QueryResult.class);
    }



    /**
     * 生成一个能够用作MDX查询的CDA文件.  若多次创建时pathId相同,则会overwrite.
     * @param pathId 要生成的文件的路径(:隔开),名称 eg:  home:youpin:youpin_srm.cda
     * @param QueryId 新建的查询名称
     * @param catalogId 使用的catalog(Analysis data source名称)
     * @param mdx mdx 查询语句
     */
    public void generateCDAfile(String pathId,String QueryId,String catalogId,String mdx){
        CDADescriptor cdaDescriptor =new CDADescriptor();
        PentahoClient pentahoClient = new PentahoClient();
        String CDAContent=generateCDAContent(cdaDescriptor,QueryId,catalogId,mdx);
        try {
            pentahoClient.createFile(pathId,CDAContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在一个原有的CDA文件上插入新的查询.
     * @param pathId 需要插入内容的文件名称(带路径)
     */
    public void addCDAfileContent(String pathId,String QueryId,String catalogId,String mdx){
        PentahoClient pentahoClient = new PentahoClient();
        String CDAContent =null;
        try {
            CDAContent = pentahoClient.getFileContent(pathId,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CDADescriptor cdaDescriptor = XmlUtil.converyToJavaBean(CDAContent,CDADescriptor.class);
        //对QueryId进行验证,看是否重复(如果重复会删掉前面的)
        //首先删除 DataAccess
        for(ListIterator lit = cdaDescriptor.getDataAccessList().listIterator();lit.hasNext();){
            DataAccess dataAccess =(DataAccess) lit.next();
            if(QueryId.equals(dataAccess.getId())){
                lit.remove();
            }
        }
        //再删除 Connection
        for(ListIterator lit = cdaDescriptor.getConnectionList().listIterator();lit.hasNext();){
            Connection connection =(Connection)lit.next();
            if(QueryId.equals(connection.getId())){
                lit.remove();
            }
        }
        CDAContent=generateCDAContent(cdaDescriptor,QueryId,catalogId,mdx);
        try {
            pentahoClient.createFile(pathId,CDAContent);//直接覆盖原有文件内容就如同更新
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成CDA文件的内容.  注:凡是带有""写死的属性在后期有需要再进行修改
     * @param cdaDescriptor  传入CDA文件的javaBean.
     * @param QueryId 新建的查询的名称
     * @param catalogId 使用的catalog(Analysis data source名称)
     * @param mdx   mdx 查询语句
     * @return CDA文件的内容
     */
    public String generateCDAContent(CDADescriptor cdaDescriptor,String QueryId,String catalogId,String mdx){

        List<Connection> connectionList;
        List<DataAccess> dataAccessList;
        if(cdaDescriptor.getConnectionList()!=null){
            connectionList=cdaDescriptor.getConnectionList();
        }else{
            connectionList=new ArrayList<>();
        }
        if(cdaDescriptor.getDataAccessList()!=null){
            dataAccessList=cdaDescriptor.getDataAccessList();
        }else{
            dataAccessList=new ArrayList<>();
        }

        String connectionId=QueryId;
        String connectionType="mondrian.jndi"; //如果后期有其他方式再做修改
        String jndi=getJndiOfAnalysisDatasource(catalogId);
        String catalog= getProviderOfAnalysisDatasource(catalogId)+":/"+jndi; // mondrian:/youpin_kdwh_srm
        Connection connection =new Connection(catalog,jndi,connectionId,connectionType);
        connectionList.add(connection);

        String access="public";
        String dataAccessType ="mdx";
        String dconnection= connectionId;
        String dataAccessId= QueryId;
        String name =QueryId;
        String bandeMode="compact";
        String Query ="<![CDATA["+mdx+"]]>";
        DataAccess.Cache cache= new DataAccess.Cache("3600","true"); //也是有需要再修改
        DataAccess dataAccess =new DataAccess(access,dconnection,dataAccessId,dataAccessType,name,bandeMode,Query,cache);
        dataAccessList.add(dataAccess);

        cdaDescriptor.setConnectionList(connectionList);
        cdaDescriptor.setDataAccessList(dataAccessList);

        return XmlUtil.convertToXml(cdaDescriptor).replace("&lt;", '<'+"").replace("&gt;",'>'+"");
    }

    /**
     * 获取AnalysisDatasource的Jndi,如youpin_kdwh_srm
     */
    public String getJndiOfAnalysisDatasource(String catalogId) {
        String Jndi=null;
        String str = null;
        try {
            str = new PentahoClient().getAnalysisDataSourceInfo(catalogId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String arr[] = str.split(";");
        for(String string:arr){
            String arr2[] = string.split("=");
            if(arr2[0].equals("Datasource")||arr2[1].matches("\\b\"\\w*\\b")==false){
                //DataSource=youpin_kdwh_srm;Datasource="youpin_kdwh_srm";...   避免拿到后面那个带引号的
                Jndi=arr2[1];
                break;
            }
        }
        return Jndi;
    }
    /**
     * 获取AnalysisDatasource的Provider,如mondrian
     */
    public String getProviderOfAnalysisDatasource(String catalogId){
        String Provider=null;
        String str = null;
        try {
            str = new PentahoClient().getAnalysisDataSourceInfo(catalogId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String arr[] = str.split(";");
        for(String string:arr){
            String arr2[] = string.split("=");
            if(arr2[0].equals("Provider")){
                Provider=arr2[1];
                break;
            }
        }
        return Provider;
    }
}
