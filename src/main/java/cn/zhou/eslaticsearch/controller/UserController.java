package cn.zhou.eslaticsearch.controller;

import cn.zhou.eslaticsearch.pojo.UserBean;
import cn.zhou.eslaticsearch.service.UserService;
import cn.zhou.eslaticsearch.tools.Judge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.List;

//本controller 统一返回 json数据
@Controller
public class UserController implements ErrorController {
    @Autowired
    private UserService userService;

    //返回视图和数据
    private ModelAndView m = new ModelAndView("/index.html");

    @PostMapping(value = "/addUser")
    public ModelAndView addUser(Integer id, String username, String password) {
        //不能为空
        Judge.isEmpty(id, username, password, m);

        //不为空则进入正常的插入操作
        if (!Judge.isNull(id, username, password)) {
            UserBean userBean = new UserBean();
            userBean.setId(id);
            userBean.setUsername(username);
            userBean.setPassword(password);
            userService.addUser(userBean);
            m.addObject("show", "添加成功!!!");
        }

        return m;
    }

    //删除 user
    @PostMapping(value = "/deleteUser")
    public ModelAndView deleteUser(Integer id, String username, String password) {
        System.out.println("deleteUser********************************");
        //最起码　id 或 username不能同时为空
        if (!Judge.isNull(id)) {
            userService.deleteById(id);
            m.addObject("show", "删除成功!!!!");
        }
        if (Judge.isNull(id) && Judge.isNull(username)) {
            m.addObject("show", "删除时,id和username不能同时为空!!!!!!");
        }

        if (Judge.isNull(id) & !Judge.isNull(username)) {
            userService.deleteByUsername(username);
            m.addObject("show", "删除成功!!!!");
        }
        return m;
    }


    //修改 user
    @PostMapping(value = "/updateUser")
    public ModelAndView updateUser(Integer id, String username, String password) {
        if (Judge.isNull(id, username, password)) {
            m.addObject("show", "不能三项都为空!!!!");
            return m;
        }

        UserBean userBean = null;
        if (!Judge.isNull(id)) {
            userBean = userService.getUserById(id);
            userBean.setId(id);
            userBean.setUsername(username);
            userBean.setPassword(password);
        }
        if (Judge.isNull(id) && Judge.isNull(username)) {
            m.addObject("show", "修改时，id和username不能同时为空!!!!!!");
            return m;
        }

        if (Judge.isNull(id) & !Judge.isNull(username)) {
            userBean = (UserBean) userService.getUserByName(username);
            userBean.setId(id);
            userBean.setUsername(username);
            userBean.setPassword(password);
        }

        //最少有一个有值，则进行修改
        userService.updateUser(userBean);
        m.addObject("show", "修改成功!!!");
        return m;
    }


    //单个查询
    @PostMapping(value = "/getUser")
    public ModelAndView getUser(Integer id, String username, String password) {

        if (!Judge.isNull(id)) {
            m.addObject("show", userService.getUserById(id));
            return m;
        }
        if (Judge.isNull(id) & Judge.isNull(username)) {
            m.addObject("show", "查询时，id和user最少有一个不为空!!!");
            return m;
        }

        if (Judge.isNull(id) & Judge.isNull(username) & Judge.isNull(password)) {
            m.addObject("show", "不能根据密码查询user!!!");
            return m;
        }

        if (Judge.isNull(id) & !Judge.isNull(username)) {
            m.addObject("show", userService.getUserByName(username));
            return m;
        }
        return m;
    }


    //查询所有 user
    @PostMapping(value = "/getAllUsers")
    public ModelAndView getAllUsers() {
        List<UserBean> allUsers = userService.getAllUsers();
        m.addObject("show", allUsers);
        return m;
    }


    //设置错误页面
    @Override
    public String getErrorPath() {
        return "/index.html";
    }
}
