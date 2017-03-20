package com.yoyohr.client.resource.saiku;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoyohr.client.Response;
import com.yoyohr.client.resource.saiku.bean.SaikuConnection;
import com.yoyohr.client.resource.saiku.bean.SaikuDimensionAndMeasure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */
public class OlapMetadataResource extends BaseResource {
    private static final Logger log = LoggerFactory.getLogger(OlapMetadataResource.class);

    private static SaikuDimensionAndMeasure saikuDimensionAndMeasure;

    private JsonDecode jsonDecode;

    public static final String OLAP_METADATA = "metadata";


    public OlapMetadataResource(Response response) throws IOException {
        super();
        this.response = response;
        jsonDecode = new JsonDecode();
    }

    public SaikuDimensionAndMeasure getSaikuDimensionAndMeasure() {
        return saikuDimensionAndMeasure;
    }

    public SaikuDimensionAndMeasure getRestOlapDimensionsAndMeasure() throws IOException {
        log.info(response.getData());
        return parseJson(response.getData());
    }

    private SaikuDimensionAndMeasure parseJson(String jsonString) {
        jsonDecode = new JsonDecode();
        return jsonDecode.decode(jsonString, SaikuDimensionAndMeasure.class);
    }
}


