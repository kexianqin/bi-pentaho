package com.yoyohr.client;

import com.yoyohr.client.resource.pentaho.bean.*;
import com.yoyohr.client.resource.pentaho.query.OlapCubeStructure;
import com.yoyohr.client.resource.pentaho.query.OlapCubes;
import com.yoyohr.client.resource.pentaho.query.QueryResult;

import java.io.IOException;


/**
 * 访问 pentaho 客户端
 *  Created by kexianqin on 2017/6/14.
 */
public interface IPentahoClient {

    /**
     * http://192.168.1.124:9090/pentaho/api  /mantle/isAuthenticated
     * 功能:认证登录信息是否正确
     */
    void isAuthenticated() throws IOException;

/**
 * ---------------------------------------- ↓Directory Resource↓ -----------------------------------------------------
 */

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/dirs/{pathId}
     * 功能:创建文件夹
     * 注:{pathId}的书写方式应该为 :path:to:file,例如 home:ke
     */
    void addDirectory(String pathId) throws IOException;

/**
 * ---------------------------------------- ↓File Resource↓ ----------------------------------------------------------
 */

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/backup
     * 功能:所有文件备份(地址设置在桌面)
     */
    void filesBackup() throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/systemRestore
     * 功能:文件还原(利用备份文件的绝对路径如:"C:/Users/Administrator/Desktop/SystemBackup.zip")
     *  @param overwrite 是否覆盖
     */
    void filesSystemRestore(String fileName,Boolean overwrite) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/{pathId}/acl
     * get功能;检索请求的存储库文件或文件夹的ACL设置,return xml或json
     * 注:{pathId}的书写方式如  home:pat:kxq.xml (带文件类型的source)
     */
    RepositoryFileAclDto getFileACL(String pathId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/delete
     * put功能: 将文件(夹)移动到垃圾堆(要获取文件ID)
     * 注:{pathId}的书写方式如  home:pat:kxq.xml (带文件类型的source)
     */
    void deleteFiles(String pathId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/deletepermanent
     * put功能:永久删除文件(夹)(要获取文件ID)
     */
    void deleteFilesPermanent(String pathId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/{pathId} -->例:home:pat:pattl.xml(需要xml扩展名)
     * put功能:在给定的路径上创建带有提供内容的新文件。
     */
    void createFile(String pathId,String stringContent) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/{pathId} -->例:home:pat:pattl.xml(需要xml扩展名)
     * get功能:获取文件内容.可以根据需要选择是否下载到桌面
     */
    String getFileContent(String pathId,Boolean download) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/{pathId }/children
     * get功能:Retrieve a list of child files from the selected repository path of the repository.
     * @param pathId  路径名,用:分隔,同上
     * @throws IOException
     */
    RepositoryFileDtoes getChildFiles(String pathId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/children
     * get功能:Retrieve a list of child files from the root of the repository.
     */
    RepositoryFileDtoes getRootChildFiles() throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/{pathId}/createDir
     * get功能:创建文件夹.
     */
    void createDir(String pathId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/tree --->例:
     *         ?depth=3&filter=*.wcdf|pattkk*|FILES|includeMembers=id,path&includeAcls=false&showHidden=false
     * @param depth 	默认值输入-1  ; How many level should the search go.
     * @param filter   默认值输入null; 三部分,中间用|间隔:
     *  1.Valid File Type:"FILES", "FOLDERS", and "FILES_FOLDERS"
     *  2.The Child Node Filter is a list of allowed names of files separated by the pipe (|) character.
     *         may be a full name or a partial name with one or more wildcard characters ("*"). The filter does not apply to root node.
     *  3.The Member Filter portion of the filter parameter allows the caller to specify which properties of the metadata to return,
     *         start with "includeMembers=" or "excludeMembers=".
     * @param showHidden 默认值输入null; Include or exclude hidden files from the file list.
     * @param includeAcls 默认值输入null;  (no documentation provided)
     * @return  以下是例子请求的返回样例(除去path就是最少包含的properties)
     * <repositoryFileTreeDto>
        <children>
            <file>
                <aclNode>false</aclNode>
                <fileSize>0</fileSize>
                <folder>false</folder>
                <hidden>false</hidden>
                <id>ddcd214f-c30e-4008-9f5b-8c4fd2aadc47</id>
                <locked>false</locked>
                <ownerType>-1</ownerType>
                <path>/home/myDashboards/myFirstDashboards.wcdf</path>
                <versioned>false</versioned>
            </file>
        <children>
      <repositoryFileTreeDto>
     * 功能:根据提供的filter从存储库的根中检索文件的递归列表。如果不带任何参数,将返回所有文件(夹)的所有properties.
     */
    RepositoryFileTreeDto getFilesTree(int depth, String filter, Boolean showHidden, Boolean includeAcls) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api  /repo/files/{pathId }/tree
     * 功能(同上):Retrieve the recursive list of children of the selected repository file.
     */
    RepositoryFileTreeDto getSelectedFilesTree(String pathId,int depth, String filter, Boolean showHidden, Boolean includeAcls) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/reservedCharacters
     * @return the list of reserved characters from the repository:"/, \, \t, \r, \nF"
     */
    String reservedCharactersDisplay() throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/reservedCharactersDisplay
     * @return the list of reserved characters from the repository:"/ \"
     */
    String getReservedCharacters() throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/properties
     * get功能:获取根目录的属性
     */
    RepositoryFileDto getPropertiesOfRootDirectory() throws  IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/deleted
     * get功能:检索垃圾文件夹中的文件列表。
     */
    RepositoryFileDtoes retrieveTrashFolder() throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/{pathId }/rename
     *   eg:pentaho/api/repo/files/:jmeter-test:test_file_1.xml/rename?newName=test_file_8
     * put功能:Rename the selected file.
     */
    void renameFile (String pathId,String newName)throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/{pathId }/properties
     * get功能:查看某文件(夹)的属性.
     */
    RepositoryFileDto getFileProperties(String pathId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/{pathId }/metadata
     *  get功能:Retrieve the metadata of the selected file. (只能返回json,使用的JsonUtil放到bean中)
     */
    StringKeyStringValueDtos getFileMetadata(String pathId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/{pathId }/metadata
     * put功能:Store the metadata of the selected file 例如,当把_PERM_HIDDEN设置为true时,此文件(夹)成为隐藏文件夹
     * @param metadata: 必须json格式,不能有拼写错误,否则显示200 OK,但是元数据属性却没有发生变化.
     *{
        "stringKeyStringValueDto": [
            {
                "key": "_PERM_SCHEDULABLE",
                "value": "true"
            },
            {
                "key": "_PERM_HIDDEN",
                "value": "false"
            }
        ]
    }
     * @throws IOException
     */
    void  putFileMetadata(String pathId,String metadata) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/{pathId }/download
     * 功能:Download the selected file or folder from the repository.(默认withManifest参数为true,即同时下载清单)
     */
    void downloadFile (String pathId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/restore
     * 功能:从垃圾箱恢复指定文件(FileId可从retrieveTrashFolder()接口获取)
     */
    void restoreFile (String FileId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /repo/files/import
     * @param fileName 需要上传的文件的全路径
     * @param DirName  上传到的文件夹,如"/home/admin"(不是:分隔)
     * post功能:本地上传文件
     * 注:该接口的Header Accept要么不设置,要么设置为text/html,所以要注意upload方法不要随意修改
     */
    void importFile (String fileName, String DirName)throws IOException;

/**
 * ---------------------------------------- ↓Session Resource↓ -------------------------------------------------------
 *     The SessionResource service lists the user's current workspace as well as the workspace folder path.
 * The following resources are applicable:
 */

    /**
     * http://192.168.1.124:9090/pentaho/api /session/userWorkspaceDir
     * get功能:Returns the current user's workspace folder path.
     */
    String getWorkspaceDir () throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/api /session/workspaceDirForUser/{user}
     * get功能:Returns the workspace folder path for the selected user.
     */
    String getWorkspaceDirForSlectedUser (String user) throws IOException;

/**
 * ---------------------------------------- ↓Analysis Resource↓ ------------------------------------------------------
 * This service allows for listing, download, upload, and removal of Analysis files or Mondrian schemas in the BA Platform.
 */

    /**
     * http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/analysis/catalog
     * get功能:Get a list of analysis data source ids.
     */
    DataSourceList getAnalysisDataSourceIds ()throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/{catalogId }/getAnalysisDatasourceInfo
     * @param catalogId AnalysisDataSource的名称,可从getAnalysisDataSourceIds()接口查询
     * get功能:返回AnalysisDataSource的信息
     * @return 字符串格式,例如: DataSource=youpin_kdwh_srm;EnableXmla=false;Provider=mondrian;Datasource="youpin_kdwh_srm";overwrite="false"
     */
    String getAnalysisDataSourceInfo (String catalogId)throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/analysis/catalog/{catalogId }
     * get功能:Download the analysis files for a given analysis id.
     * @param catalogId 例如:youpin_kdwh_srm,可从 getAnalysisDataSourceIds()接口查询
     * @return 保存的文件名
     */
    String downloadAnalysisFile (String catalogId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/analysis/catalog/{catalogId }
     * delete功能:Remove the analysis data for a given analysis ID.
     * @param catalogId 例如:youpin_kdwh_srm,可从 getAnalysisDataSourceIds()查询
     */
    void deleteAnalysisFile (String catalogId)throws IOException;

    /**    ???---> 此接口比较奇怪,catalogId处随便填点什么就行了... 最后显示的Datasource名称由上传的xml文件的schema name决定 如<Schema name="youpin_kdwh_srm">
     * http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/analysis/catalog/{catalogId }
     * @param catalogId 随便填?
     * @param fileName  文件绝对路径,A Mondrian schema XML file.
     * @param overwrite Flag for overwriting existing version of the file
     * @param xmlaEnabledFlag Is XMLA enabled or not.
     * @param parameters  说明: requestBody中必须有 key="parameters",value="Datasource=(youpin_kdwh_srm)" ,其中(youpin_kdwh_srm)
     *                    保存了带有jdbc的数据源,即和数据库连接.故在接口的实现中,直接将此参数作为datasource传入,即传入(youpin_kdwh_srm).
     * put功能:Import Analysis Schema.   注:所有参数均不能为空,否则访问出错
     */
    void importAnalysisSchema (String catalogId,String fileName,boolean overwrite,boolean xmlaEnabledFlag,String parameters)throws IOException;


/**
 * ---------------------------------------- ↓JDBC Datasource Resource↓ -----------------------------------------------
 * This service provides methods for listing, creating, downloading, uploading, and removal of JDBC data sources.
 */

    /**
     *http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/jdbc/connection
     * get功能:Get a list of JDBC datasource IDs.
     */
    DataSourceList getJdbcDataSourceIds ()throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/jdbc/connection/{connectionId }
     * get功能:Export a JDBC datasource connection.
     *          注意: !!-->下载文件到桌面,文件名为null(因为该接口未返回文件名),所以要下载多个文件,则在下好第一个后改名,否则会覆盖.
     * @param connectionId JDBC连接名,可从上一个接口查询.
     * @return 下载的文件名null.
     */
    String downloadJdbcDataSourceConnection (String connectionId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/jdbc/connection/{connectionId }
     * get功能:和上面访问的是同一个接口,也是get,但是没有下载而是获得一个包含连接信息的DatabaseConnection对象.
     * @param connectionId JDBC连接名,可从getJdbcDataSourceIds()查询.
     * @return 包含连接信息的DatabaseConnection对象.
     */
    DatabaseConnectionJ getJdbcDataSourceConnection(String connectionId) throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/jdbc/connection/{connectionId }
     * put功能:Add or update a JDBC datasource connection.  post内容只能使用json格式.
     * @param connectionId 当changed为false时,可以随意命名;当changed为true时,connectionId就是要更新的jdbc名字.
     *          注意:若是数据库名称,密码等参数和实际不符,也会显示JDBC上传成功,但是不能正常连接到数据库.
     */
    void addOrUpdateJdbcDataSourceConnection(String connectionId,String connectionName, String databaseTypeName,
                                             String hostname, String databasePort,String databaseName,String username,
                                             String password,boolean changed)  throws IOException;

    /**
     *  http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/jdbc/connection/{connectionId }
     * delete功能:Remove the JDBC data source for a given JDBC ID.
     */
    void deleteJdbcDataSourceConnection(String connectionId)  throws IOException;

/**
 * ---------------------------------------- ↓Metadata Resource↓ ------------------------------------------------------
 * This service allows for listing, download, and removal of Metadata data sources in the BA Platform.
 */

    /**
     *http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/metadata/domain
     * get功能:Get the Metadata datasource IDs.
     */
    DataSourceList getMetadataDataSourceIds()throws IOException;

    /**
     *http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/metadata/domain/{domainId }
     * get功能:Export a metadata datasource.
     * @param domainId 可从getMetadataDataSourceIds()查询.
     * @return 下载的文件名
     */
    String downloadMetadataDatasource (String domainId)throws IOException;

    /**
     *http://192.168.1.124:9090/pentaho/plugin/data-access/api/datasource/metadata/domain/{domainId }
     * delete功能:Remove the metadata for a given metadata ID.
     * @param domainId 可从getMetadataDataSourceIds()查询.
     * @return 下载的文件名
     */
    void deleteMetadataDatasource (String domainId)throws IOException;

/**
 * ---------------------------------------- ↓Query↓ ------------------------------------------------------------------
 * 用作查询的各种接口
 */

    /**
     * http://192.168.1.124:9090/pentaho/plugin/pentaho-cdf-dd/api/olap/getCubes
     * get功能:返回所有能够作为查询的catalogs以及下面的cubes.
     */
    OlapCubes getOlapCubes()throws IOException;

    /**
     *http://192.168.1.124:9090/pentaho/plugin/pentaho-cdf-dd/api/olap/getCubeStructure?catalog={catalogId }&cube={cubeId }
     * get功能:查询指定的cube结构,即 measures,dimension,hierarchy之类
     */
    OlapCubeStructure getCubeStructure(String catalog,String cube)throws IOException;

    /**
     * http://192.168.1.124:9090/pentaho/plugin/cda/api/doQuery?path={path }&dataAccessId={dataAccessId }
     * @param path 以/隔开的包含文件的完整路径 eg:home/youpin/iLoveYou.cda
     * @param dataAccessId 查询的Id(即为这个query取的名称)
     * @param catalogId 也即analysis dataSource, eg:youpin_kdwh_srm,一个mondrian schema文件.
     * @param mdx mdx查询语句
     * @return mdx查询结果
     * 注:若不加 catalogId,mdx 这两个参数,则是查询已存在的查询.(要正确填写path,dataAccessId确保能够找到该查询)
     *  path 如果存在,则在已存在文件进行查询操作;若不存在,则新建path文件,在新文件中查询.
     *  dataAccessId 如果存在,则新建查询会覆盖原有查询(之前的会被删除);如果不存在,则新建名字为dataAccessId的查询.
     */
    QueryResult doQuery(String path,String dataAccessId,String catalogId,String mdx) throws IOException;
}
