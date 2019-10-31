package cn.zhou.mybaties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//    完成以上，下面在启动类里加上注解用于给出需要扫描的mapper文件路径
//    @MapperScan("com.example.mapper")
//@MapperScan("cn.zhou.mybaties.dao")
@SpringBootApplication
public class MybatiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatiesApplication.class, args);
    }

}
