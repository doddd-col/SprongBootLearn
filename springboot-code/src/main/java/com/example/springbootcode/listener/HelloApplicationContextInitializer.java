package com.example.springbootcode.listener;

import org.springframework.boot.web.reactive.context.ConfigurableReactiveWebApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @program: springboot-code
 * @description:
 * @author: doddd
 * @create: 2020-02-23 19:43
 **/
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ConfigurableApplicationContext..............initialize"+configurableApplicationContext);

    }
}
