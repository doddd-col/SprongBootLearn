package com.doddd.cache;

import com.doddd.cache.bean.Employee;
import com.doddd.cache.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.persistence.Access;

@SpringBootTest
class SpringBootCacheLearnApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;
    // 操作字符串
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate<Object, Employee> redisTemplate;
    // 操作kv对
    //@Autowired
    //RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        //stringRedisTemplate.opsForValue().set("java","hello world");
        //String java = stringRedisTemplate.opsForValue().get("java");
        //System.out.println(java);
        //stringRedisTemplate.opsForList().leftPush("mylist", "1 2 3 4");
        //System.out.println(stringRedisTemplate.opsForList().leftPop("mylist"));

        Employee employee = employeeRepository.findById(1).get();
        //默认保存对象是使用jdk序列化器，序列化后保存到redis
        String emp = "emp";
        redisTemplate.opsForValue().set(emp,employee);
        System.out.println(redisTemplate.opsForValue().get("emp"));
        //自己将对象转为Json
        //redisTemplate默认的序列化规则
    }



    @Test
    public void CRUDTest(){
        Employee one = employeeRepository.getOne(1);
        System.out.println(one);

    }

}
