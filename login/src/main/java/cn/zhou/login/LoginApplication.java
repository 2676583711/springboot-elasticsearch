package cn.zhou.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


//extends SpringBootServletInitializer
/*
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(LoginApplication.class);
        return builder;
    }
 */


@SpringBootApplication
public class LoginApplication  {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }



}



