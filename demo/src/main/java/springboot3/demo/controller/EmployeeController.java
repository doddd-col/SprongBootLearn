package springboot3.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot3.demo.dao.DepartmentDao;
import springboot3.demo.dao.EmployeeDao;
import springboot3.demo.entities.Department;
import springboot3.demo.entities.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {


    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Map<String, Object> map){
        Collection<Employee> all = employeeDao.getAll();

        map.put("emps",all);
        return "emp/list";

    }

    @GetMapping("/emp")
    public String toAddPage(Model model){

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        // redirect 代表重定向 /代表当前项目路径
        // forward: 表示转发到一个地址
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id") Integer id ,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        return "emp/add";

    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
       employeeDao.save(employee);
       return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public  String deleteEmp(@PathVariable("id") Integer id){
        System.out.println(1);
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
