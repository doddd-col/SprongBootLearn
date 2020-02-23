package com.doddd.springboot;

import com.doddd.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.lang.annotation.Retention;

/**
 * @program: spring-boot-starter-test
 * @description:
 * @author: doddd
 * @create: 2020-02-23 22:47
 **/
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return helloService.sayHelloToYou("李四");
    }

}
