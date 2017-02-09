package com.wenyu.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/2/9.
 */
@Component/*不加这个注解使用@Autowired会失败*/
@ConfigurationProperties(prefix = "com.wenyu.pojo")
@Getter
@Setter
public class TestPojo {
    private String id;
    private String name;
    private String age;
    private String birthDay;
}
