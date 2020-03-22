package com.doddd.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @program: spring-boot-shiro
 * @description:
 * @author: doddd
 * @create: 2020-03-04 17:44
 **/
@Controller
public class MyController {

    @GetMapping("/")
    public String toLogin(Map<String, String> map) {
        map.put("msg", "helloworld");
        return "index";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/update")
    public String update() {
        return "update";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/login")
    public String login(String username, String password, Map<String, String> map) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);
            return "index";
        } catch (UnknownAccountException e) {
            map.put("msg", "用户名不存在");
            return "login";
        } catch (IncorrectCredentialsException e) {
            map.put("msg", "密码错误");
            return "login";
        }
    }

    @ResponseBody
    @GetMapping("/noauthc")
    public String noauthc(){
        return "未经授权";
    }
}
