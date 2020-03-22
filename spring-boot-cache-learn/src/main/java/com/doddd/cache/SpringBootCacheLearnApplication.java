package com.doddd.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author doddd
 */
@SpringBootApplication
@EnableCaching
public class SpringBootCacheLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheLearnApplication.class, args);
    }

}
