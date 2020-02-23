package com.example.springbootcode.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @program: springboot-code
 * @description:
 * @author: doddd
 * @create: 2020-02-23 20:03
 **/
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner.............run"+ Arrays.asList(args));
    }
}
