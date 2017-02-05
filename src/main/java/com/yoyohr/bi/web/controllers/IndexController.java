package com.yoyohr.bi.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hello World";
    }
}
