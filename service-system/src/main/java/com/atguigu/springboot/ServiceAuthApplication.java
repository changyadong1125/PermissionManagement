package com.atguigu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * project:PermissionManagement
 * package:com.atguigu.springboot.system
 * class:ServiceAuthApplication
 *
 * @author: smile
 * @create: 2023/4/26-16:16
 * @Version: v1.0
 * @Description:
 */
@MapperScan(basePackages = "com.atguigu.springboot.mapper")
@SpringBootApplication
public class ServiceAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAuthApplication.class, args);
    }

}
