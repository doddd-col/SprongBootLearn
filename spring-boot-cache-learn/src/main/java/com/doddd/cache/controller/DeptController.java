package com.doddd.cache.controller;

import com.doddd.cache.bean.Department;
import com.doddd.cache.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: spring-boot-cache-learn
 * @description:
 * @author: doddd
 * @create: 2020-02-28 20:12
 **/
@Controller
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/dept/{id}")
    public Department queryDeptById(@PathVariable("id") Integer id) {
        Department department = deptService.queryDeptById(id);
        System.out.println(department);
        return department;
    }

}
