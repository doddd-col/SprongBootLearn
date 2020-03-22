package com.doddd.rabbitmq.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: spring-boot-rabbitmq
 * @description:
 * @author: doddd
 * @create: 2020-03-01 20:18
 **/

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String name;
    private String author;
}
