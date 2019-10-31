package cn.zhou.eslaticsearch.tools;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public class Judge {

    public static boolean isNull(Integer id) {
        if (id == null || id.equals("")) {
            return true;
        }
        return false;
    }


    public static boolean isNull(String username) {

        if (username == null || username.equals("")) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Integer id, String username) {

        if (isNull(id) & isNull(username)) {
            return true;
        }
        return false;
    }

    public static boolean isNull(Integer id, String username, String password) {

        if (isNull(id) & isNull(username) & isNull(password)) {
            return true;
        }
        return false;
    }


    public static boolean isEmpty(Integer id, String username, String password, ModelAndView m) {
        if (isNull(id, username, password)) {
            if (Judge.isNull(password)) {
                m.addObject("show", "三项不能为空!!!!!!");
                return true;
            }
        }

        if (Judge.isNull(id)) {
            m.addObject("show", "ID不能为空!!!!!!");
            return true;
        }
        if (Judge.isNull(username)) {
            m.addObject("show", "username不能为空!!!!!!");
            return true;
        }
        if (Judge.isNull(password)) {
            m.addObject("show", "password不能为空!!!!!!");
            return true;
        }
        return false;
    }


    public static boolean isEmpty(Integer id, String username, ModelAndView m) {
        if (Judge.isNull(id)) {
            m.addObject("show", "ID不能为空!!!!!!");
            return true;
        }
        if (Judge.isNull(username)) {
            m.addObject("show", "username不能为空!!!!!!");
            return true;
        }

        return false;
    }

}
