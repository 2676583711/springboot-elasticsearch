package cn.zhou.mybaties.service;

import cn.zhou.mybaties.model.UserBean;

import java.util.List;

//业务层
public interface UserService {
    public UserBean getUserByName(String userName);

//    public List<UserBean> getUserByName(String userName);

}
