package cn.zhou.login.cn.zhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
RestController: return "直接显示返回的字符串"
Controller: 返回指定的页面
 */
//@RestController
@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(String username, String password) {
//        return "are you ok";
        return "msg";
    }
}
