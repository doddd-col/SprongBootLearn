package com.springboot.springbootjdbc.jdbc;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @program: springboot-jdbc
 * @description:
 * @author: doddd
 * @create: 2020-02-22 14:06
 **/
@Component
public class jdbcTest {

    @Autowired
    DataSource dataSource;

    @SneakyThrows
    @Test
    public void jdbcTest(){
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

}
