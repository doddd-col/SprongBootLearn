package springboot3.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;
import springboot3.demo.exception.UserNotExistException;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class HttpController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        if (name.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "hello world";
    }

    @RequestMapping("/success")
    public String success(Map<String, List> map) {
        map.put("success", Arrays.asList("成功", "你好"));
        return "success";
    }

    @PostMapping("/dashboard")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Map<String, String> map) {
        if (!StringUtils.isEmpty(username) && "1".equals(password)) {
            // 设置session 通过interceptor
            session.setAttribute("loginUser", username);
            // 登录成功 防止表单重复提交 重定向到主页
            return "redirect:/main.html";
        }
        map.put("msg", "账号或密码错误");
        return "index";
    }

//    @RequestMapping({"/","/index.html"})
//    public String index(){
//       return "index" ;
//    }

}
