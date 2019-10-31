package cn.zhou.eslaticsearch.pojo;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * 在elasticsearch中
 * index 相当于 mysql中的数据库
 * type 相当于 mysql中的数据库中的表
 * document 相当于 mysql中的数据库中的表中的一行记录数
 * <p>
 * 如果我们要访问一个文档元数据应该包括囊括 index/type/id 这三种类型
 */

@Document(indexName = "first_store", type = "users")
public class UserBean {
    @Id
    private Integer id;
    @Field
    private String username;
    @Field
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
