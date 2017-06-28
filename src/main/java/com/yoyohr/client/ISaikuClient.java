package com.yoyohr.client;

import com.yoyohr.client.resource.saiku.bean.*;
import com.yoyohr.client.resource.saiku.query.QueryResult;

import java.io.IOException;
import java.util.List;

/**
 * 访问Saiku Server的客户端
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public interface ISaikuClient {

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/session
     */
    SaikuSession getRestSaikuSession() throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover
     */
    List<SaikuConnection> getRestOlapConnections() throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/refresh
     */
    List<SaikuConnection> refreshRestOlapConnections() throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}
     */
    List<SaikuConnection> getRestOlapConnection(String connectionName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/refresh
     */
    List<SaikuConnection> refreshRestOlapConnection(String connectionName) throws IOException;


    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube}/metadata
     */
    SaikuCubeMetadata getRestSaikuCubeMetadata(String saikuCubeUniqueName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube}/dimensions
     */
    List<SaikuDimension> getRestSaikuDimensions(String saikuCubeUniqueName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube
     * }/dimensions/{dimension}
     */
    SaikuDimension getRestSaikuDimension(String saikuCubeUniqueName, String dimensionName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube
     * }/dimensions/{dimension}/hierarchies
     */
    List<SaikuHierarchy> getRestSaikuDimensionHierarchies(String saikuCubeUniqueName,
                                                          String dimensionName) throws IOException;


    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube
     * }/dimensions/{dimension}/hierarchies/{hierarchy}/levels
     */
    List<SaikuLevel> getRestSaikuDimensionHierarchy(String saikuCubeUniqueName, String dimensionName,
                                                    String hierarchyName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube
     * }/dimensions/{dimension}/hierarchies/{hierarchy}/levels/{level}
     */
    List<SimpleCubeElement> getRestSaikuLevelMembers(String saikuCubeUniqueName, String dimensionName,
                                                     String hierarchyName, String levelName) throws IOException;


    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube
     * }/hierarchies/{hierarchy}/rootmembers
     */
    List<SaikuMember> getRestSaikuRootMembers(String saikuCubeUniqueName,
                                              String hierarchyName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube
     * }/hierarchies/
     */
    List<SaikuHierarchy> getRestSaikuCubeHierarchies(String saikuCubeUniqueName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube
     * }/measures/
     */
    List<SaikuMeasure> getRestSaikuCubeMeasures(String saikuCubeUniqueName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube
     * }/member/{member}      (measures 下面的)
     */
    SaikuMember getRestSaikuMember(String saikuCubeUniqueName, String memberName) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{cube
     * }/member/{member}/children
     */
    List<SaikuMember> getRestSaikuMemberChildren(String saikuCubeUniqueName, String memberName) throws IOException;


    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/api/query/execute
     */
    QueryResult executeSaikuQuery(String cubeUniqueName, String mdx) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/admin/datasources
     * Used to get all the available data sources on the platform
     */
    List<SaikuAdminDatasource> getAvailableAdminDataSources() throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/api/admin/schema
     * Get all the available schema
     */
    List<SaikuAdminMondrianSchema> getAvailableAdminMondrianSchemas() throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/api/admin/schema/{id 例如foodmart4.xml}
     * Get Saved Schema By ID
     */
    String getSavedSchema(String id) throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/api/admin/users
     * Get existing Saiku users from the Saiku server
     */
    List<SaikuAdminUser> getExistingAdminUsers() throws IOException;

    /**
     * https://pentaho.yoyohr.com/saiku/rest/saiku/api/admin/users/{id 例如1(每个user下面都有一个id)}
     * Get user details for a user in the Saiku server
     */
    SaikuAdminUser getUserDetails(int id) throws IOException;
}
