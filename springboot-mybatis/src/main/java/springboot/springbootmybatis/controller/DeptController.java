package springboot.springbootmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springboot.springbootmybatis.bean.Department;
import springboot.springbootmybatis.bean.Employee;
import springboot.springbootmybatis.mapper.DepartmentMapper;
import springboot.springbootmybatis.mapper.EmployeeMapper;

/**
 * @program: springboot-mybatis
 * @description: Dept控制层
 * @author: doddd
 * @create: 2020-02-22 17:59
 **/
@RestController
public class DeptController {

    @Autowired(required = false)
    DepartmentMapper departmentMapper;

    @Autowired(required = false)
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department queryDepartmentById(@PathVariable("id")Integer id){
        Department department = departmentMapper.queryDepartmentById(id);
        return department;
    }

    @GetMapping("/dept")
    public Department insertDepartment(Department department){
        departmentMapper.insertDepartment(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee queryEmpById(@PathVariable("id")Integer id){
        return employeeMapper.queryEmpById(id);
    }
}
