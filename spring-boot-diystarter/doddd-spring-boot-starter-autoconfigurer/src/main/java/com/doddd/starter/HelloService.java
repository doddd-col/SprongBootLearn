package com.doddd.starter;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: spring-boot-diystarter
 * @description:
 * @author: doddd
 * @create: 2020-02-23 22:12
 **/
public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHelloToYou(String name){
        return helloProperties.getPrefix()+" "+name+" "+helloProperties.getSuffix();
    }
}
