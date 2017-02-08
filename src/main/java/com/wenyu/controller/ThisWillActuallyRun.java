package com.wenyu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/2/8.
 */
@RestController
@RequestMapping("/run")
public class ThisWillActuallyRun {
    protected static Logger logger= LoggerFactory.getLogger(ThisWillActuallyRun.class);
    @RequestMapping("/hello")
    String home() {
        logger.info("hello");
        return "Hello World!";
    }

    @RequestMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        logger.info("访问helloName,Name={}",name);
        return "Hello "+name;
    }
}
