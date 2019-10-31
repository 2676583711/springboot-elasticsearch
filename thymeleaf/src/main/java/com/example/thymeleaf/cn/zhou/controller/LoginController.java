package com.example.thymeleaf.cn.zhou.controller;


import com.example.thymeleaf.cn.zhou.model.UserBean;
import com.example.thymeleaf.cn.zhou.model.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LoginController {

    @Resource
    private UserDao userDao;

    @RequestMapping("/login")
    public String login(String username, String password, Model m) {
        System.out.println("/login................." + username + ":" + password);
        m.addAttribute("username", username);
        m.addAttribute("password", password);

        List<UserBean> all = userDao.findAll();
        for (UserBean ub : all) {
            if (username.equals(ub.getUsername()) & password.equals(ub.getPassword())) {
                System.out.println("msg*************");

//            userDao.save(new UserBean(username, password));
//            UserBean userBean = new UserBean();
//            userBean.setUsername(username);
//            userBean.setPassword(password);
//            userDao.save(userBean);

                return "show/msg";
            }
        }

        m.addAttribute("msg",username+" or "+password+"错误!!!");

        return "index";
    }
}
