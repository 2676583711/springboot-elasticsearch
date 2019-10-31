package cn.zhou.mybaties.dao;

import cn.zhou.mybaties.model.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

//mapper接口，定义方法交由mybaties实现方法体
@Mapper
//@Repository
public interface UserDao {
    public UserBean getUserByName(String UserName);
}
