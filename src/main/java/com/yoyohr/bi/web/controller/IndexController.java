package com.yoyohr.bi.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yoyohr.client.SaikuClient;
import com.yoyohr.client.UnanthenticatedException;
import com.yoyohr.client.resource.saiku.bean.SaikuCubeMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    protected static Logger log= LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws UnanthenticatedException, IOException, URISyntaxException {
        return "ok";

    }
}
