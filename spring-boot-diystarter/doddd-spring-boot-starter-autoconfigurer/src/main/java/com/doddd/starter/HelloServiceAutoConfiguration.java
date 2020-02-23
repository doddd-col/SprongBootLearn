package com.doddd.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-boot-diystarter
 * @description:
 * @author: doddd
 * @create: 2020-02-23 22:17
 **/
@Configuration
@ConditionalOnWebApplication
// 通过这个注解开启对使用了@ConfigurationProperties这个注解类的支持 可以直接通过注入拿到对象
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Autowired
    HelloProperties helloProperties;
    @Bean
    public HelloService helloService(){
        HelloService service = new HelloService();
        // 将HelloProperties 与HelloService绑定 (这样才可以传值)
        service.setHelloProperties(helloProperties);
        return service;
    }
}
