package springboot.springbootdatajpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @program: springboot-data-jpa
 * @description:
 * @author: doddd
 * @create: 2020-02-23 14:42
 **/

// 使用jpa注解配置映射关系
@Entity     // 告诉jpa这是一个实体类(和数据表映射)
@Table(name = "tbl_user") //指定哪个数据表 如果省略表名默认是user
@JsonIgnoreProperties(value = "hibernateLazyInitializer")
@Data
public class User {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //这是一个自增主键
    private Integer id;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column  // 省略默认列名是属性名
    private String email;
}
