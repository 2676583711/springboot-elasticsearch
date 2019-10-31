package cn.zhou.eslaticsearch.dao;


import cn.zhou.eslaticsearch.pojo.UserBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 Couldn't find PersistentEntity for type class java.lang.Object!
	at org.springframework.beans.factory.annotation.
	AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.
	inject(AutowiredAnnotationBeanPostProcessor.java:639)
	~[spring-beans-5.2.0.RELEASE.jar:5.2.0.RELEASE]

	ElasticsearchRepository接口 必须指定泛型
 */

//针对 user　实体类的 dao数据访问层
//由于　基于jpa格式封装了其他的　持久层产品
// es需要特别指定属于自己的pojo类的扫描路径

/*
@EnableElasticsearchRepositories(
        basePackages = "cn.zhou.eslaticsearch.pojo",
        includeFilters = @ComponentScan.Filter(value = EnableElasticsearchRepositories.class))
*/

@Repository
public interface UserDao extends ElasticsearchRepository<UserBean, Object> {

    //按照 id查询
    UserBean findById(Integer id);

    //按照用户名查找
    List<UserBean> findByUsername(String username);

    //按照密码查询
    List<UserBean> findByPassword(String password);

    //按照用户名删除
    void deleteByUsername(String username);
    //按照 id删除
    void deleteById(Integer id);

    //查询所有
    List<UserBean> findAll();
}
