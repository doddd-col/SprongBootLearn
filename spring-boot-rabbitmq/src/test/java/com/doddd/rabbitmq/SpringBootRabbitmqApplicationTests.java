package com.doddd.rabbitmq;

import com.doddd.rabbitmq.bean.Book;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
class SpringBootRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;
    @Test
    void createEx(){
        amqpAdmin.declareExchange(new DirectExchange("amqp_ex"));
        amqpAdmin.declareQueue(new Queue("ex_queue",true));
        amqpAdmin.declareBinding(new Binding("ex_queue", Binding.DestinationType.QUEUE,"amqp_ex","amqp",null));
    }
    @Test
    void contextLoads() {
        val map = new HashMap<String, Object>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        rabbitTemplate.convertAndSend("exchange.direct", "doddd.news", map);

    }

    @Test
    void receive() {
        val o = rabbitTemplate.receiveAndConvert("doddd.news");
        System.out.println(o.getClass());
        System.out.println(o);

    }

    @Test
    void sendMsg(){
        Book book = Book.builder().name("西游记").author("张三").build();
        rabbitTemplate.convertAndSend("exchange.fanout","",book);
    }

}
