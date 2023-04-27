package com.atguigu.springboot;

import com.atguigu.springboot.mapper.SysRoleMapper;
import com.atguigu.springboot.model.system.SysRole;
import com.atguigu.springboot.service.SysRoleService;
import com.atguigu.springboot.service.SysRoleServiceImp;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import javax.management.Query;
import java.util.ArrayList;
import java.util.Collections;
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
    @Resource
    private SysRoleService sysRoleServiceImp;

    @Test
    public void test01() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        sysRoles.forEach(System.out::println);
    }
    @Test
    public void insertTest(){
        sysRoleMapper.insert(new SysRole("普通用户","hello","普通用户"));
    }
    @Test
    public void updateTest(){
        SysRole sysRole = sysRoleMapper.selectById(8);
        sysRole.setRoleName("高级管理员");
        int i = sysRoleMapper.updateById(sysRole);
        System.out.println("i = " + i);
    }
    @Test
    public void testQueryWrapper(){
        QueryWrapper<SysRole> sysRoleQueryWrapper = new QueryWrapper<>();
        QueryWrapper<SysRole> sysRole = sysRoleQueryWrapper.ge("id", 9);
        System.out.println("sysRole = " + sysRole);
    }
    @Test
    public void testService(){
        System.out.println("============================selectAll method test==================================");
        List<SysRole> list = sysRoleServiceImp.list();
        list.forEach(System.out::println);
    }
    @Test
    public void testInsert(){
        ArrayList<SysRole> sysRoles = new ArrayList<>();
        Collections.addAll(sysRoles,new SysRole("null","12","33"),new SysRole("null","123","33"));
        sysRoleServiceImp.saveBatch(sysRoles,2);
    }
}
