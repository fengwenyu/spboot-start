package com.wenyu.controller;

import com.wenyu.domain.TestPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/2/9.
 */
@RestController
@RequestMapping("yml")
public class YmlConfigController {
    @Autowired
    TestPojo testPojo;
    @RequestMapping("/pojo")
    public TestPojo testYumConfig(){
        return testPojo;
    }
}
