package com.springboot.springbootjdbc.jdbc;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @program: springboot-jdbc
 * @description:
 * @author: doddd
 * @create: 2020-02-22 14:17
 **/
public class jdbcTest {

    @Autowired
    DataSource dataSource;

    @SneakyThrows
    public void jdbcTest(){
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

    public static void main(String[] args) {
        jdbcTest jdbcTest = new jdbcTest();
        jdbcTest.jdbcTest();

    }
}
