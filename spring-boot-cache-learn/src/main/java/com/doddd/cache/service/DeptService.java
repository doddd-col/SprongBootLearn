package com.doddd.cache.service;

import com.doddd.cache.bean.Department;
import com.doddd.cache.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-cache-learn
 * @description:
 * @author: doddd
 * @create: 2020-02-28 20:08
 **/
@CacheConfig(cacheNames = "dept")
@Service
public class DeptService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Cacheable
    public Department queryDeptById(Integer id) {
        Department department = departmentRepository.findById(id).get();
        return department;
    }
}
