package com.wenyu.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/2/24.
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "mq")
public class RabbitmqBean {
    private String host;
    private String username;
    private String password;
    private String port;
    private String vhost;

}
