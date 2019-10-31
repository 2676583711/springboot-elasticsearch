package cn.zhou.eslaticsearch.service;

import cn.zhou.eslaticsearch.dao.UserDao;
import cn.zhou.eslaticsearch.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 在 spring中
 * <p>
 * 下面三个注解作用都是　把类交由spring bean管理,只不过为了便于区分
 * 才划分了三个三个不同的注解
 *
 * @Service 用于业务层
 * @Component　用于普通的类　（非mvc）
 * @Repository 持久层　（ｄａｏ）
 * @Controller 展示层
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(UserBean user) {
        UserBean save = (UserBean) userDao.save(user);
    }

    @Override
    public boolean deleteUser(UserBean user) {
        try {
            userDao.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("现在的异常是：删除失败");
            return false;
        }
        return true;
    }

    @Override
    public void deleteByUsername(String username) {
        userDao.deleteByUsername(username);
    }

    //修改
    @Override
    public boolean updateUser(UserBean user) {
        userDao.index(user);

        userDao.refresh();
        return false;
    }

    //********************查询*************************
    @Override
    public UserBean getUserById(int id) {
        return userDao.findById(id);
    }

    @Override
    public List<UserBean> getAllUsers() {
        return (List<UserBean>) userDao.findAll();
    }

    @Override
    public List<UserBean> getUserByName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<UserBean> getUserByPassword(String password) {
        return userDao.findByPassword(password);
    }
}
