package springboot.springbootdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.springbootdatajpa.entity.User;

/**
 * @program: springboot-data-jpa
 * @description:
 * @author: doddd
 * @create: 2020-02-23 14:53
 **/

// 继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {
}
