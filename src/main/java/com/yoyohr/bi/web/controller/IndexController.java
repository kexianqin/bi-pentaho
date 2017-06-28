package com.yoyohr.bi.web.controller;

import com.yoyohr.client.UnanthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
@Controller
public class IndexController {

    protected static Logger log= LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
     public String index(){
        return "init";
    }
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//    @RequestMapping("/logout")
//    public String logout() {
//        return "logout";
//    }
    @RequestMapping("/error/priv_error")
    public String error() {
        return "priv_error";
    }
}
