package com.example.springbootcode.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-code
 * @description:
 * @author: doddd
 * @create: 2020-02-23 20:02
 **/
@Component
public class HelloApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner............run");
    }
}
