package springboot.springbootmybatis.mapper;

import springboot.springbootmybatis.bean.Employee;

/**
 * @program: springboot-mybatis
 * @description: 员工映射
 * @author: doddd
 * @create: 2020-02-22 19:45
 **/
public interface EmployeeMapper {
    public Employee  queryEmpById(Integer id);

    public void insertEmp(Employee employee);
}
