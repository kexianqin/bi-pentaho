package com.yoyohr.bi.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
@Controller
public class IndexController {

    protected static Logger log= LoggerFactory.getLogger(IndexController.class);

//    @RequestMapping("/lol/{variable}/o2o")
//    public String inde(@PathVariable ("variable") String variable ) throws UnanthenticatedException, IOException, URISyntaxException {
//        return "ok， 武汉大学欢迎您！";
//    }
//    @RequestMapping(value="lol",params={"age=23"})   //限定了年龄的值只能为23，否则无法访问
//    public String indexx(@RequestParam(required = false) String name,@RequestParam("age") int age) throws UnanthenticatedException, IOException, URISyntaxException {
//        return "ok， 武汉大学欢迎您！+1";
//    }
//    @RequestMapping(value = "lal",method = RequestMethod.POST) //???????????????????????question
//    public String indexxx(@CookieValue("hello") String cookievalue) throws UnanthenticatedException, IOException, URISyntaxException {
//        return "ok， 武汉大学欢迎您！+2";
//    }
//    @RequestMapping("/xixi")
//    public String indexxxxx(@RequestHeader("Host") String hostAdder) throws UnanthenticatedException, IOException, URISyntaxException {
//        System.out.println( hostAdder);
//        return "ok， 武汉大学欢迎您！+3";
//    }
    @RequestMapping("/")
     public String index(){
        return "init";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }
    @RequestMapping("/error/priv_error")
    public String error() {
        return "priv_error";
    }
}
