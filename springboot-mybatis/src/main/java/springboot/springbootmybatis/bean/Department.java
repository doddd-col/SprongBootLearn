package springboot.springbootmybatis.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @program: springboot-mybatis
 * @description: 部门表
 * @author: doddd
 * @create: 2020-02-22 17:35
 **/

@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String departmentName ;
}
