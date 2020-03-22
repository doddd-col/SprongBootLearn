package com.doddd.cache.service;

import com.doddd.cache.bean.Employee;
import com.doddd.cache.repository.EmployeeRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.management.Query;

/**
 * @program: spring-boot-cache-learn
 * @description:
 * @author: doddd
 * @create: 2020-02-24 17:40
 **/
@CacheConfig(cacheNames = "emp")
@Service
public class EmployeeService {

        @Autowired
        EmployeeRepository employeeRepository;



        /**
         * @Author doddd
         * @Description 查询员工
         * @Date 6:24 下午 2020/2/24
         * @Param [id]
         * @return com.doddd.cache.bean.Employee
         **/
        @Cacheable(condition = "#id>0", unless = "#result == null")
        public Employee queryEmpById(@NonNull Integer id){

                System.out.println("查询了id: "+id+" 的员工");
                Employee employee = employeeRepository.findById(id).get();
                return employee;
        }

        @CachePut(key = "#result.id")
        public Employee updateEmpById(Employee employee){
                Employee save = employeeRepository.save(employee);
                return save;
        }

        @CacheEvict(allEntries = true)
        public void deleteEmpById(Integer id ){
                System.out.println("delete:"+id);
        }

        @Caching(
                cacheable = {
                        @Cacheable()
                },
                put = {
                        @CachePut(key = "#result.id"),
                        @CachePut(key = "#result.email")
                }

        )
        public Employee queryEmpByLastName(){
                return null;
        }
}
