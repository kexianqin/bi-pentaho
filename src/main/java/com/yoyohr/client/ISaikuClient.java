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
     * }/member/{member}
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
     *  访问https://pentaho.yoyohr.com/saiku/rest/saiku/{username}/discover/{connection}/{catalog}/{schema}/{caption}/metadata
     * @return
     * @throws IOException
     */
//    SaikuDimensionAndMeasure getRestOlapDimensions() throws IOException;

    



}
