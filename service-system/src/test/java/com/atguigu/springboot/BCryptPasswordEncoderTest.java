package com.atguigu.springboot;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * project:PermissionManagement
 * package:com.atguigu.springboot
 * class:BCryptPasswordEncoder
 *
 * @author: smile
 * @create: 2023/5/8-16:19
 * @Version: v1.0
 * @Description:
 */
@SpringBootTest
public class BCryptPasswordEncoderTest {

    @Test
    public void test() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println("encode = " + encode);
        String encode1 = bCryptPasswordEncoder.encode("123456");
        System.out.println("encode1 = " + encode1);
    }


}
