package com.doddd.shiro.service;

import com.doddd.shiro.repository.UserRepository;
import com.doddd.shiro.entity.User;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-shiro
 * @description:
 * @author: doddd
 * @create: 2020-03-04 19:35
 **/
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(String userName){
        val user = userRepository.findByUserName(userName);
        return user;
    }
}
