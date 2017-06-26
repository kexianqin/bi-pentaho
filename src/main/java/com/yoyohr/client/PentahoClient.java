package com.yoyohr.client;
import com.yoyohr.client.resource.pentaho.AnalysisResouce;
import com.yoyohr.client.resource.pentaho.FileResouce;
import com.yoyohr.client.resource.pentaho.bean.*;
import com.yoyohr.util.PropertiesReader;
import com.yoyohr.util.XmlUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.HttpClients;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        String requestUri=getApiUri("/api/mantle/isAuthenticated");
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
        String requestUri = getApiUri("/api/repo/dirs/"+pathId);
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
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/backup");
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
    public void filesSystemRestore(String fileName,Boolean overwrite) throws IOException{
        FileResouce resouce =new FileResouce();
        String requestUri= getApiUri(resouce.PENTAHO_API+"/systemRestore");
        Map<String,String> formData = new HashMap<>();
        formData.put("overwrite",String.valueOf(overwrite));
        Response response = upload(requestUri,fileName,formData);
        if(response.getCode()==0){
            log.info("备份文件导入成功");
        }else if(response.getCode()==403){
            log.info("无管理员权限");
        }else{
            log.info("备份失败");
        }
    }

    @Override
    public RepositoryFileAclDto getFileACL(String pathId) throws IOException{
        FileResouce resouce=new FileResouce();
        String requestUri =getApiUri(resouce.PENTAHO_API+"/"+pathId+"/acl");
        Response response =get(requestUri);
        if(response.getCode()==0){
            log.info("成功返回请求的文件权限");
        }
        if(response.getCode()==500){
            log.info("未找到对应文件,可能是由无效路径或不存在的文件造成的");
        }
        resouce.setResponse(response);
        return resouce.parseRepositoryFileAclDto();
    }

    @Override
    public void deleteFiles(String pathId) throws IOException{
        FileResouce resouce =new FileResouce();
        String requestUri =getApiUri(resouce.PENTAHO_API+"/delete");
        String fileId = getFileId(pathId);
        Response response = put(requestUri,fileId);
        if(response.getCode()==0){
            log.info("成功将文件扔进垃圾桶");
        }
        if(response.getCode()==500){
            log.info("删除失败,无此文件");
        }
    }

    @Override
    public void deleteFilesPermanent(String pathId) throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri =getApiUri(resouce.PENTAHO_API+"/deletepermanent");
        String fileId = getFileId(pathId);
        Response response = put(requestUri,fileId);
        if(response.getCode()==0){
            log.info("成功永久删除该文件");
        }
        if(response.getCode()==500){
            log.info("删除失败,无此文件");
        }
    }
    @Override
    public void createFile(String pathId,String stringContent) throws IOException{
        FileResouce resouce =new FileResouce();
        String requestUri =getApiUri(resouce.PENTAHO_API+"/"+pathId);
        Response response =put(requestUri,stringContent);
        if(response.getCode()==0){
            log.info("成功创建文件");
        }
        if(response.getCode()==500){
            log.info("文件创建失败:"+response.getData());
        }
    }

    @Override
    public String getFileContent(String pathId,Boolean download) throws IOException{
        FileResouce resouce =new FileResouce();
        String requestUri =getApiUri(resouce.PENTAHO_API+"/"+pathId);
        if(download ==true){
            Response response =getFile(requestUri);
            if(response.getCode()==0){
                log.info("成功下载文件");
            }else{
                log.info("文件下载失败");
            }
        }
        Response response =get(requestUri);
        if(response.getCode()==0){
            log.info("成功获取文件内容");
        }
        if(response.getCode()==404){
            log.info("未找到文件");
        }
        if(response.getCode()==500){
            log.info("打开内容失败");
        }
        return response.getData();
    }

    @Override
    public RepositoryFileDtoes getChildFiles(String pathId) throws IOException{
        FileResouce resouce =new FileResouce();
        String requestUri =getApiUri(resouce.PENTAHO_API+"/"+pathId+"/children");
        Response response =get(requestUri);
        if(response.getCode()==0){
            log.info("成功获取"+pathId+"下所有文件");
        }else{
            log.info("啊哦出错了");
        }
        resouce.setResponse(response);
        return resouce.parseRepositoryFileDtoes();
    }

    @Override
    public RepositoryFileDtoes getRootChildFiles() throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri =getApiUri(resouce.PENTAHO_API+"/children");
        Response response =get(requestUri);
        if(response.getCode()==0){
            log.info("成功获取根目录下所有文件");
        }else{
            log.info("啊哦出错了");
        }
        resouce.setResponse(response);
        return resouce.parseRepositoryFileDtoes();
    }

    @Override
    public void createDir(String pathId) throws IOException{
        FileResouce resouce =new FileResouce();
        String requestUri =getApiUri(resouce.PENTAHO_API+"/"+pathId+"/createDir");
        Response response =put(requestUri);
        if(response.getData().equals("couldNotCreateFolderDuplicate") && response.getCode()==409){
            log.info(pathId+"该文件夹已存在");
        }
        if(response.getCode()==0){
            log.info(pathId+"文件夹创建成功");
        }
    }

    @Override
    public RepositoryFileTreeDto getFilesTree(int depth, String filter, Boolean showHidden, Boolean includeAcls) throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/tree");
        Map params = new HashMap<String, String>();
        if (depth != -1) {
            params.put("depth", String.valueOf(depth));
        }
        if (filter != null) {
            params.put("filter", String.valueOf(filter));
        }
        if (showHidden != null) {
            params.put("showHidden", String.valueOf(showHidden));
        }
        if (includeAcls != null) {
            params.put("includeAcls", String.valueOf(includeAcls));
        }
        Response response = get(requestUri, params);
        if (response.getCode() == 0) {
            log.info("成功根据条件检索出文件列表");
        }
        if(response.getCode()==404){
            log.info("Invalid parameters");
        }
        if(response.getCode()==500){
            log.info("Server Error");
        }
        resouce.setResponse(response);
        return resouce.parseRepositoryFileTreeDto();
    }

    @Override
    public RepositoryFileTreeDto getSelectedFilesTree(String pathId, int depth, String filter, Boolean showHidden, Boolean includeAcls) throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/"+pathId+"/tree");
        Map params = new HashMap<String, String>();
        if (depth != -1) {
            params.put("depth", String.valueOf(depth));
        }
        if (filter != null) {
            params.put("filter", String.valueOf(filter));
        }
        if (showHidden != null) {
            params.put("showHidden", String.valueOf(showHidden));
        }
        if (includeAcls != null) {
            params.put("includeAcls", String.valueOf(includeAcls));
        }
        Response response = get(requestUri, params);
        if (response.getCode() == 0) {
            log.info("成功根据条件检索出文件列表");
        }
        if(response.getCode()==404){
            log.info("Invalid parameters");
        }
        if(response.getCode()==500){
            log.info("Server Error");
        }
        resouce.setResponse(response);
        return resouce.parseRepositoryFileTreeDto();
    }

    @Override
    public String reservedCharactersDisplay() throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/reservedCharactersDisplay");
        Response response=get(requestUri);
        if (response.getCode() == 0) {
            log.info("成功获取保留字符串");
        }
        return response.getData();
    }

    @Override
    public String getReservedCharacters() throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/reservedCharacters");
        Response response=get(requestUri);
        if (response.getCode() == 0) {
            log.info("成功获取保留字符串");
        }
        return response.getData();
    }

    @Override
    public RepositoryFileDto getPropertiesOfRootDirectory() throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/properties");
        Response response =get(requestUri);
        resouce.setResponse(response);
        log.info(response.getData());
        if (response.getCode() == 0) {
            log.info("成功获得根目录属性");
        }
        if(response.getCode()==404){
            log.info("未找到文件");
        }
        if(response.getCode()==500){
            log.info("啊哦出错了");
        }
        return resouce.parseRepositoryFileDto();
    }

    @Override
    public RepositoryFileDtoes retrieveTrashFolder() throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/deleted");
        Response response=get(requestUri);
        if (response.getCode() == 0) {
            log.info("成功获得垃圾文件");
        }
        if(response.getCode()==500){
            log.info("Server Error");
        }
        resouce.setResponse(response);
        return resouce.parseRepositoryFileDtoes();
    }

    @Override
    public void renameFile(String pathId, String newName) throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/"+pathId+"/rename?newName="+newName);
        Response response=put(requestUri);
        if (response.getCode() == 0) {
            log.info("改名成功");
        }if(response.getCode()==500){
            log.info("文件名的选择或更改有问题");
        }
    }

    @Override
    public RepositoryFileDto getFileProperties(String pathId) throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/"+pathId+"/properties");
        Response response=get(requestUri);
        if (response.getCode() == 0) {
            log.info("查看文件(夹)属性成功");
        }if(response.getCode()==204){
            log.info("文件(夹)路径无效");
        }
        resouce.setResponse(response);
        return resouce.parseRepositoryFileDto();
    }

    @Override
    public StringKeyStringValueDtos getFileMetadata(String pathId) throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/"+pathId+"/metadata");
        Response response=get(requestUri);
        if (response.getCode() == 0) {
            log.info("查看文件(夹)元数据成功");
        }if(response.getCode()==204){
            log.info("文件(夹)路径无效");
        }
        resouce.setResponse(response);
        return resouce.parseStringKeyStringValueDtos();
    }

    @Override
    public void putFileMetadata(String pathId, String metadata) throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/"+pathId+"/metadata");
        Response response=put(requestUri,null,metadata,"application/json");
        if (response.getCode() == 0) {
            log.info("文件(夹)元数据put成功");
        }if(response.getCode()==500){
            log.info("有此文件(夹)吗?");
        }if(response.getCode()==400){
            log.info("无效的数据");
        }
    }

    @Override
    public void downloadFile(String pathId) throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/"+pathId+"/download");
        Response response=getFile(requestUri);
        if (response.getCode() == 0) {
            log.info("下载成功");
        }if(response.getCode()==400){
            log.info("Usually a bad pathId");
        }if(response.getCode()==404){
            log.info("File not found");
        }
    }

    @Override
    public void restoreFile(String FileId) throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/restore");
        Response response=put(requestUri,FileId);
        if (response.getCode() == 0) {
            log.info("文件还原成功!");
        }else{
            log.info("文件还原失败!");
        }
    }

    @Override
    public void importFile(String fileName, String DirName) throws IOException {
        FileResouce resouce =new FileResouce();
        String requestUri = getApiUri(resouce.PENTAHO_API+"/import");
        HashMap<String,String> formData = new HashMap<>();
        formData.put("importDir",DirName);
        Response response = upload(requestUri,fileName,formData);
        if (response.getCode() == 0) {
            log.info("文件上传成功!");
        }else{
            log.info("文件上传失败!");
        }
    }

    @Override
    public String getWorkspaceDir() throws IOException {
        String requestUri=getApiUri("/api/session/userWorkspaceDir");
        Response response=get(requestUri);
        if (response.getCode() == 0) {
            log.info("成功返回了文件路径!");
        }else{
            log.info("哪里出现了问题");
        }
        return response.getData();
    }

    @Override
    public String getWorkspaceDirForSlectedUser(String user) throws IOException {
        String requestUri=getApiUri("/api/session/workspaceDirForUser"+"/"+user);
        Response response=get(requestUri);
        if (response.getCode() == 0) {
            log.info("成功返回了文件路径!");
        }else{
            log.info("哪里出现了问题");
        }
        return response.getData();
    }

    @Override
    public DataSourceList getAnalysisDataSourceIds() throws IOException {
        AnalysisResouce resouce =new AnalysisResouce();
        String requestUri=getApiUri(resouce.PENTAHO_API);
        Response response =get(requestUri);
        if (response.getCode() == 0) {
            log.info("成功获取了所有分析文件ID");
        }else{
            log.info("出现了问题");
        }
        resouce.setResponse(response);
        return resouce.parseDataSourceList();
    }

    @Override
    public String downloadAnalysisFile(String catalogId) throws IOException {
        AnalysisResouce resouce =new AnalysisResouce();
        String requestUri=getApiUri(resouce.PENTAHO_API+"/"+catalogId);
        Response response =getFile(requestUri);
        if (response.getCode() == 0) {
            log.info("成功下载了"+catalogId);
        }else{
            log.info("下载出现了问题");
        }
        return response.getData();
    }

    @Override
    public void deleteAnalysisFile(String catalogId) throws IOException {
        AnalysisResouce resouce =new AnalysisResouce();
        String requestUri=getApiUri(resouce.PENTAHO_API+"/"+catalogId);
        Response response =delete(requestUri);
        if (response.getCode() == 0) {
            log.info("成功删除了"+catalogId);
        }else{
            log.info("删除出现了问题");
        }
    }

    @Override
    public void importAnalysisSchema(String catalogId, String fileName, boolean overwrite, boolean xmlaEnabledFlag, String datasource) throws IOException {
        AnalysisResouce resouce =new AnalysisResouce();
        String requestUri=getApiUri(resouce.PENTAHO_API+"/"+catalogId);
        HashMap<String,String> formData = new HashMap<>();
        formData.put("overwrite",String.valueOf(overwrite));
        formData.put("xmlaEnabledFlag",String.valueOf(xmlaEnabledFlag));
        formData.put("parameters","Datasource="+datasource);
        Response response = putUpload(requestUri,"uploadInput",fileName,formData);
        if (response.getCode() == 0 ||response.getCode() == 201) {
            log.info("导入成功");
        }else if (response.getCode() == 409) {
            log.info("请检查是否重复导入(你或许设置了不覆盖)");
        }else{
            log.info("导入失败");
        }
    }


    public static void main(String[] args) throws UnanthenticatedException, IOException, URISyntaxException,DocumentException{
        PentahoClient pentahoclient =new PentahoClient();
        System.out.println(XmlUtil.convertToXml(pentahoclient.getAnalysisDataSourceIds()));
//        pentahoclient.downloadAnalysisFile("youpin_kdwh_srm");
//        pentahoclient.deleteAnalysisFile("youpin_kdwh_srm");

//        pentahoclient.importAnalysisSchema("lalalalalalalalalala",
//            "C:/Users/Administrator/Desktop/youpin改版2017-05-26-6-1.xml",false,false,"AgileBI");


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

    /**
     * 通过访问 getFileACL 接口来获取文件或文件夹的ID
     * @param pathId
     * @return id of the file
     */
    public String getFileId(String pathId) throws IOException {
        RepositoryFileDto repositoryFileDto = getFileProperties(pathId);
        return repositoryFileDto.getId();
    }

    private String getApiUri(String endpoint) {
        String uri = getApiBase(PENTAHO_CONTEXT) + endpoint; //    http://(192.168.1.124:9090)/pentaho+...
        log.debug("===========" + uri);
        return uri;
    }
}


