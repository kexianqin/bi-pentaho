package com.yoyohr.client.resource.saiku;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoyohr.client.Response;
import com.yoyohr.client.resource.saiku.bean.SaikuConnection;
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

    public static final String OLAP_DISCOVER = "discover";

    private ObjectMapper objectMapper;

    private List<SaikuConnection> olapConnections;

    public OlapDiscoverResource(Response response) {
        super(response);
        objectMapper = new ObjectMapper();
    }

    /**
     * 读取OlapConnections信息
     *
     * @return String
     * @throws IOException
     */
    public List<SaikuConnection> getRestOlapConnections() throws IOException {
        log.info(response.getData());
        return parseJson(response.getData());
    }

    public List<SaikuConnection> getOlapConnections() {
        return olapConnections;
    }


    private JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    private List<SaikuConnection> parseJson(String jsonString) throws IOException {
        JavaType javaType = getCollectionType(ArrayList.class, SaikuConnection.class);
        olapConnections = objectMapper.readValue(jsonString, javaType);
        return olapConnections;
    }

    public static void main(String[] args) throws IOException {
        OlapDiscoverResource resource = new OlapDiscoverResource(null);
        String jsonString = "[{\"uniqueName\":\"earthquakes\",\"name\":\"earthquakes\"," +
                "\"catalogs\":[{\"uniqueName\":\"Global Earthquakes\",\"name\":\"Global Earthquakes\",\"schemas\":[{\"uniqueName\":\"Global Earthquakes\",\"name\":\"Global Earthquakes\",\"cubes\":[{\"uniqueName\":\"[earthquakes].[Global Earthquakes].[Global Earthquakes].[Earthquakes]\",\"name\":\"Earthquakes\",\"connection\":\"earthquakes\",\"catalog\":\"Global Earthquakes\",\"schema\":\"Global Earthquakes\",\"caption\":\"Earthquakes\",\"visible\":true}]}]}]},{\"uniqueName\":\"foodmart\",\"name\":\"foodmart\",\"catalogs\":[{\"uniqueName\":\"FoodMart\",\"name\":\"FoodMart\",\"schemas\":[{\"uniqueName\":\"FoodMart\",\"name\":\"FoodMart\",\"cubes\":[{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[HR]\",\"name\":\"HR\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"HR\",\"visible\":true},{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[Sales]\",\"name\":\"Sales\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"Sales\",\"visible\":true},{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[Sales 2]\",\"name\":\"Sales 2\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"Sales 2\",\"visible\":true},{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[Store]\",\"name\":\"Store\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"Store\",\"visible\":true},{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[Warehouse]\",\"name\":\"Warehouse\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"Warehouse\",\"visible\":true},{\"uniqueName\":\"[foodmart].[FoodMart].[FoodMart].[Warehouse and Sales]\",\"name\":\"Warehouse and Sales\",\"connection\":\"foodmart\",\"catalog\":\"FoodMart\",\"schema\":\"FoodMart\",\"caption\":\"Warehouse and Sales\",\"visible\":true}]}]}]}]";
        System.out.println(resource.parseJson(jsonString));
    }
}
