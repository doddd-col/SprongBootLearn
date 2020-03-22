package com.doddd.shiro.repository;

import com.doddd.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: spring-boot-shiro
 * @description:
 * @author: doddd
 * @create: 2020-03-04 19:01
 **/
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserName(String name);
}
