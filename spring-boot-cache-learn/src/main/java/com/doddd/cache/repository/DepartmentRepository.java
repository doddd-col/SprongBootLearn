package com.doddd.cache.repository;

import com.doddd.cache.bean.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: spring-boot-cache-learn
 * @description:
 * @author: doddd
 * @create: 2020-02-28 20:09
 **/
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
