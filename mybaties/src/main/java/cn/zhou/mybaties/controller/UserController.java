package cn.zhou.mybaties.controller;


import cn.zhou.mybaties.model.UserBean;
import cn.zhou.mybaties.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RestController
public class UserController {

    @Resource
    UserService us;

    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest hsr, Model m) {

        System.out.println(username + ":" + password);
        UserBean tom = us.getUserByName(username);

        if(tom==null){
            hsr.setAttribute("username", "null异常");
//            m.addAttribute("username", "null异常");
            System.out.println(" NullPointerException.................................");
            return "index";
        }


        String userName = tom.getUsername();


        hsr.setAttribute("username", userName);
//        m.addAttribute("username", userName);
        System.out.println(tom.getUsername() + ":" + tom.getPassword() + ":" + tom.getId());


        return "index";
    }
}
