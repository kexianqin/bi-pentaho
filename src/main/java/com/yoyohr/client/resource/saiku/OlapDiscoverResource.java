package com.yoyohr.client.resource.saiku;

import com.fasterxml.jackson.core.type.TypeReference;
import com.yoyohr.client.resource.saiku.bean.*;
import com.yoyohr.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class OlapDiscoverResource extends BaseResource {

    private static final Logger log = LoggerFactory.getLogger(OlapDiscoverResource.class);

    public static final String DISCOVER = "/discover/";
    public static final String DIMENSIONS = "/dimensions/";
    public static final String HIERARCHIES = "/hierarchies/";


    public OlapDiscoverResource() {
        super();
    }

    public String getUriOfGetRestOlapConnections() {
        return "/discover";
    }

    public String getUriOfRefreshRestOlapConnections() {
        return "/discover/refresh";
    }

    public String getUriOfGetRestOlapConnection(String connectionName) {
        return DISCOVER + connectionName;
    }

    public String getUriOfRefreshRestOlapConnection(String connectionName) {
        return DISCOVER + connectionName + "/refresh";
    }

    /**
     * saikuCubeUniqueName: [connection].[catalog].[schema].[cube]
     */
    public String getUriOfGetRestCubeMetadata(String saikuCubeUniqueName) {
        //将字符串"[connection].[catalog].[schema].[cube]"转换为字符串数组"connection/catalog/schema/cube"
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + "/metadata";
    }

    public String getUriOfGetRestSaikuDimensions(String saikuCubeUniqueName) {
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + "/dimensions";
    }

    public String getUriOfGetRestSaikuDimension(String saikuCubeUniqueName, String dimensionName) {
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + DIMENSIONS + dimensionName;
    }


    public String getUriOfGetRestSaikuDimensionHierarchies(String saikuCubeUniqueName, String dimensionName) {
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + DIMENSIONS + dimensionName
            + "/hierarchies";
    }

    public String getUriOfGetRestSaikuDimensionHierarchy(String saikuCubeUniqueName,
                                                         String dimensionName,
                                                         String hierarchyName) {
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + DIMENSIONS
            + dimensionName + HIERARCHIES + hierarchyName + "/levels";
    }

    public String getUriOfGetRestSaikuLevelMembers(String saikuCubeUniqueName,
                                                   String dimensionName,
                                                   String hierarchyName,
                                                   String levelName) {
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + DIMENSIONS + dimensionName
            + "/hierarchies/" + hierarchyName + "/levels/" + levelName;
    }

    public String getUriOfGetRestSaikuRootMembers(String saikuCubeUniqueName, String hierarchyName) {
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + HIERARCHIES + hierarchyName + "/rootmembers";
    }

    public String getUriOfGetRestSaikuCubeHierarchies(String saikuCubeUniqueName) {
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + "/hierarchies";
    }

    public String getUriOfGetRestSaikuCubeMeasures(String saikuCubeUniqueName) {
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + "/measures";
    }

    public String getUriOfGetRestSaikuMember(String saikuCubeUniqueName, String memberName) {
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + "/member/" + memberName;
    }

    public String getUriOfGetRestSaikuMemberChildren(String saikuCubeUniqueName, String memberName) {
        return DISCOVER + convertSaikuCubeUniqueName(saikuCubeUniqueName) + "/member/" + memberName + "/children";
    }

    public List<SaikuConnection> parseSaikuConnections() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), new TypeReference<List<SaikuConnection>>() {
        });
    }

    public SaikuCubeMetadata parseSaikuCubeMetaData() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), SaikuCubeMetadata.class);
    }

    public List<SaikuDimension> parseSaikuDimensions() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), new TypeReference<List<SaikuDimension>>() {
        });
    }

    public SaikuDimension parseSaikuDimension() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), SaikuDimension.class);
    }

    public List<SaikuHierarchy> parseSaikuHierarchies() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), new TypeReference<List<SaikuHierarchy>>() {
        });
    }

    public List<SaikuLevel> parseSaikuLevels() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), new TypeReference<List<SaikuLevel>>() {
        });
    }

    public List<SimpleCubeElement> parseSaikuLevelMembers() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), new TypeReference<List<SimpleCubeElement>>() {
        });
    }

    public List<SaikuMeasure> parseSaikuMeasures() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), new TypeReference<List<SaikuMeasure>>() {
        });
    }

    public SaikuMember parseSaikuMember() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), SaikuMember.class);
    }

    public List<SaikuMember> parseSaikuMembers() throws IOException {
        log.info(response.getData());
        return JsonUtil.parseJson(response.getData(), new TypeReference<List<SaikuMember>>() {
        });
    }

    //将字符串"[connection].[catalog].[schema].[cube]"转换为字符串数组"connection/catalog/schema/cube"
    private String convertSaikuCubeUniqueName(String saikuCubeUniqueName) {
        return saikuCubeUniqueName.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\\.", "/");
    }


}
