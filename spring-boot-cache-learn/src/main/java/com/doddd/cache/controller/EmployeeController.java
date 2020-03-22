package com.doddd.cache.controller;

import com.doddd.cache.bean.Employee;
import com.doddd.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-cache-learn
 * @description:
 * @author: doddd
 * @create: 2020-02-24 17:44
 **/
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee queryEmpById(@PathVariable("id") Integer id){
        Employee employee = employeeService.queryEmpById(id);
        return employee;
    }

    @GetMapping("/emp")
    public Employee updateEmpById(Employee employee){
        Employee emp = employeeService.updateEmpById(employee);
        return emp;
    }

    @GetMapping("/emp/delete")
    public String deleteEmpById(@RequestParam Integer id){
        employeeService.deleteEmpById(id);
        return "success";
    }
}
