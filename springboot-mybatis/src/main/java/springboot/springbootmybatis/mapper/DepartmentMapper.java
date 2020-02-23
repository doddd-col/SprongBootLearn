package springboot.springbootmybatis.mapper;

import org.apache.ibatis.annotations.*;
import springboot.springbootmybatis.bean.Department;

/**
 * @program: springboot-mybatis
 * @description: 部门数据库映射
 * @author: doddd
 * @create: 2020-02-22 17:38
 **/
//@Mapper
public interface DepartmentMapper {

    /**
     * @Author doddd
     * @Description 按部门Id查询
     * @Date 5:48 下午 2020/2/22
     * @Param [id]
     * @return springboot.springbootmybatis.bean.Department
     **/
    @Select("select * from department where id=#{id}")
    public Department queryDepartmentById(Integer id);


    /**
     * @Author doddd
     * @Description 按部门Id删除
     * @Date 6:06 下午 2020/2/22
     * @Param [id]
     * @return int
     **/
    @Delete("delete from department where id=#{id}")
    public int deleteDepartmentById(Integer id);

    /**
     * @Author doddd
     * @Description 新增部门
     * @Date 5:49 下午 2020/2/22
     * @Param [department]
     * @return int
     **/
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public int insertDepartment(Department department);

    /**
     * @Author doddd
     * @Description 按部门Id修改部门信息
     * @Date 5:50 下午 2020/2/22
     * @Param [department]
     * @return int
     **/
    @Update("Update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDepartmentById(Department department);
}
