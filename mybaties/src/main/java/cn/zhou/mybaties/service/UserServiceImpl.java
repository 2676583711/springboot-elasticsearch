package cn.zhou.mybaties.service;

import cn.zhou.mybaties.model.UserBean;
import cn.zhou.mybaties.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//标志 service
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao ud;

    @Override
    public  UserBean getUserByName(String userName) {
        return ud.getUserByName(userName);
    }
}
