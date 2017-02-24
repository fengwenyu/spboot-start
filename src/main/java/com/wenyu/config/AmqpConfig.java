package com.wenyu.config;

import com.rabbitmq.client.Channel;
import com.wenyu.domain.RabbitmqBean;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by Administrator on 2017/2/24.
 */
@Configuration
public class AmqpConfig {
    public static final String FOO_EXCHANGE   = "callback.exchange.foo";
    public static final String FOO_ROUTINGKEY = "callback.routingkey.foo";
    public static final String FOO_QUEUE      = "callback.queue.foo";

    @Autowired
    private RabbitmqBean rabbitmqBean;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(rabbitmqBean.getHost());
        connectionFactory.setUsername(rabbitmqBean.getUsername());
        connectionFactory.setPassword(rabbitmqBean.getPassword());
        connectionFactory.setVirtualHost(rabbitmqBean.getVhost());
        /** 如果要进行消息回调，则这里必须要设置为true */
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    /** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }




}
