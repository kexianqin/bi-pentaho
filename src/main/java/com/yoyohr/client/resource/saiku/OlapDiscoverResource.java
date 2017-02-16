package com.yoyohr.client.resource.saiku;

import com.fasterxml.jackson.databind.JavaType;
import com.yoyohr.client.resource.saiku.bean.SaikuConnection;
import com.yoyohr.client.resource.saiku.bean.SaikuCubeMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class OlapDiscoverResource extends BaseResource {

    private static final Logger log = LoggerFactory.getLogger(OlapDiscoverResource.class);

    public OlapDiscoverResource() {
        super();
    }

    /**
     * saikuCubeUniqueName: [connection].[catalog].[schema].[cube]
     */
    public String getUriOfGetRestCubeMetadata(String saikuCubeUniqueName) {
        //将字符串"[connection].[catalog].[schema].[cube]"转换为字符串数组"connection/catalog/schema/cube"
        String namesInUri = saikuCubeUniqueName.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\\.","/");

        return "/discover/" + namesInUri + "/metadata";
    }


    public String getUriOfGetRestOlapConnection(String connectionName) {
        return "/discover/" + connectionName;
    }

    public String getUriOfGetRestOlapConnections() {
        return "/discover";
    }

    public String getUriOfRefreshRestOlapConnection(String connectionName) {
        return "/discover/" + connectionName + "/refresh";
    }

    public String getUriOfRefreshRestOlapConnections() {
        return "/discover/refresh";
    }


    public List<SaikuConnection> parseOlapConnection() throws IOException {
        log.info(response.getData());
        JavaType javaType = getCollectionType(ArrayList.class, SaikuConnection.class);
        return objectMapper.readValue(response.getData(), javaType);
    }

    public List<SaikuConnection> parseOlapConnections() throws IOException {
        log.info(response.getData());
        JavaType javaType = getCollectionType(ArrayList.class, SaikuConnection.class);
        return objectMapper.readValue(response.getData(), javaType);
    }

    public SaikuCubeMetadata parseSaikuCubeMetaData() throws IOException {
        log.info(response.getData());
        return objectMapper.readValue(response.getData(), SaikuCubeMetadata.class);
    }

    public static void main(String[] args) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource();
//        String jsonString = "[{\"uniqueName\":\"earthquakes\",\"name\":\"earthquakes\"," +
//                "\"catalogs\":[{\"uniqueName\":\"Global Earthquakes\",\"name\":\"Global Earthquakes\",\"schemas\":[{\"uniqueName\":\"Global Earthquakes\",\"name\":\"Global Earthquakes\",\"cubes\":[{\"uniqueName\":\"[earthquakes].[Global Earthquakes].[Global Earthquakes].[Earthquakes]\",\"name\":\"Earthquakes\",\"connection\":\"earthquakes\",\"catalog\":\"Global Earthquakes\",\"schema\":\"Global Earthquakes\",\"caption\":\"Earthquakes\",\"visible\":true}]}]}]},{\"uniqueName\":\"foodmart\",\"name\":\"foodmart\",\"catalogs\":[{\"uniqueName\":\"FoodMart\",\"name\":\"FoodMart\",\"schemas\":[{\"uniqueName\":\"FoodMart\",\"name\":\"FoodMart\",\"cubes\":[{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[HR]\",\"name\":\"HR\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"HR\",\"visible\":true},{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[Sales]\",\"name\":\"Sales\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"Sales\",\"visible\":true},{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[Sales 2]\",\"name\":\"Sales 2\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"Sales 2\",\"visible\":true},{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[Store]\",\"name\":\"Store\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"Store\",\"visible\":true},{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[Warehouse]\",\"name\":\"Warehouse\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"Warehouse\",\"visible\":true},{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[Warehouse and Sales]\",\"name\":\"Warehouse and Sales\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"Warehouse and Sales\",\"visible\":true}]}]}]}]";
//        resource.setResponse(new Response(0, jsonString));
//        String cubeName = "[youpin_dwh].[youpin_dwh].[youpin_dwh].[youpin_dwh]";
        String cubeName = "[a].[b].[c].[d]";
        String uri = resource.getUriOfGetRestCubeMetadata(cubeName);
        log.info(uri);
    }
}
