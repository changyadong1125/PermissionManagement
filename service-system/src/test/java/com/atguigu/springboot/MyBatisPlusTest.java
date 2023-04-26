package com.atguigu.springboot;

import com.atguigu.springboot.mapper.SysRoleMapper;
import com.atguigu.springboot.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.List;

/**
 * project:PermissionManagement
 * package:com.atguigu.spring
 * class:MyBatisPlusTest
 *
 * @author: smile
 * @create: 2023/4/26-16:29
 * @Version: v1.0
 * @Description:
 */
@SpringBootTest
public class MyBatisPlusTest {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Test
    public void test01() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        sysRoles.forEach(System.out::println);
    }
}
