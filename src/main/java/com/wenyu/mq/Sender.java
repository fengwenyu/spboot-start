package com.wenyu.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/2/24.
 */
@Component
public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String msg) {
        this.rabbitTemplate.convertAndSend("foo", msg);
    }
}
