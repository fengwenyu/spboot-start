package com.wenyu.controller;

import com.wenyu.mq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/2/24.
 */
@RestController
public class RabbitMqController {
    @Autowired
    private Sender sender;

    @RequestMapping("/send")
    public String send(HttpServletRequest request, String msg) {
        sender.send(msg);
        return "Send OK.";
    }
}
