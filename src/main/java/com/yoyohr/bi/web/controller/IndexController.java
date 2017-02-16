package com.yoyohr.bi.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoyohr.client.SaikuClient;
import com.yoyohr.client.UnanthenticatedException;
import com.yoyohr.client.resource.saiku.bean.SaikuCubeMetadata;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws UnanthenticatedException, IOException, URISyntaxException {
        SaikuClient client = new SaikuClient();
        String cubeUniqueName = "[youpin_dwh].[youpin_dwh].[youpin_dwh].[youpin_dwh]";
        SaikuCubeMetadata cubeMetadata = client.getRestSaikuCubeMetadata(cubeUniqueName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(cubeMetadata);
    }
}
