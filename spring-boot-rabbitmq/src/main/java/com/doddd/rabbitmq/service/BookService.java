package com.doddd.rabbitmq.service;

import com.doddd.rabbitmq.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-rabbitmq
 * @description:
 * @author: doddd
 * @create: 2020-03-01 20:19
 **/
@Service
public class BookService {

    @RabbitListener(queues = "doddd.news")
    public void receive(Book book){
        System.out.println("获取到的信息: "+book);
    }

    @RabbitListener(queues = "aqx.news")
    public void receiveMsg(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
