package springboot.springbootmybatis.bean;

import lombok.*;

/**
 * @program: springboot-mybatis
 * @description: 员工表
 * @author: doddd
 * @create: 2020-02-22 17:31
 **/
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Getter
    @Setter
    @NonNull private Integer id;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private Integer gender;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Integer dId;
}
