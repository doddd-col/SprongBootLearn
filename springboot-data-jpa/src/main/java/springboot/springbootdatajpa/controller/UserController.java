package springboot.springbootdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springboot.springbootdatajpa.entity.User;
import springboot.springbootdatajpa.repository.UserRepository;

/**
 * @program: springboot-data-jpa
 * @description:
 * @author: doddd
 * @create: 2020-02-23 15:20
 **/
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")Integer id){
        User one = userRepository.getOne(id);
        return one;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }

}
