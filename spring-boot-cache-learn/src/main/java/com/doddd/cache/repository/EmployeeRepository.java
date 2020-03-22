package com.doddd.cache.repository;

import com.doddd.cache.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: spring-boot-cache-learn
 * @description:
 * @author: doddd
 * @create: 2020-02-24 17:04
 **/
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
