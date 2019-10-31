package cn.zhou.eslaticsearch.service;

import cn.zhou.eslaticsearch.pojo.UserBean;

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

// user服务层
public interface UserService {
    //添加 user
    public void addUser(UserBean user);

    //删除　user
    public boolean deleteUser(UserBean user);

    //修改 user
    public boolean updateUser(UserBean user);

    //查询 user 按 id查询
    public UserBean getUserById(int id);

    //查询　所有 user
    public List<UserBean> getAllUsers();

    //按用户名查询
    public List<UserBean> getUserByName(String username);


    //按密码查询
    public List<UserBean> getUserByPassword(String password);

    //按照用户名删除
    void deleteByUsername(String username);

    //按照 id删除
    void deleteById(Integer id);
}
