package com.example.thymeleaf.cn.zhou.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface UserDao extends JpaRepository<UserBean, Integer> {
    public List<UserBean> findAllById(Integer id);


    public UserBean findAllByName(String username);

    public List<UserBean> findPassword(String password);

}
