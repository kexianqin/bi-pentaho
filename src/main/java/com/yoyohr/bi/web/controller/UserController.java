package com.yoyohr.bi.web.controller;

import com.yoyohr.bi.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
@RestController
public class UserController {
    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User index(@RequestParam(value = "name", defaultValue = "World")String name) {
        return new User(counter.incrementAndGet(),
                String.format(TEMPLATE, name));
    }
}
