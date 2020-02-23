package com.springboot.springbootjdbc;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class SpringbootJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJdbcApplication.class, args);


    }



}
