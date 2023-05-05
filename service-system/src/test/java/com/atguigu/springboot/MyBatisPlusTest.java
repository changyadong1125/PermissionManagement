package com.atguigu.springboot;

import com.atguigu.springboot.mapper.SysRoleMapper;
import com.atguigu.springboot.model.system.SysRole;
import com.atguigu.springboot.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.*;

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
    public void insertTest() {
        sysRoleMapper.insert(new SysRole("普通用户", "hello", "普通用户"));
    }

    @Test
    public void updateTest() {
        SysRole sysRole = sysRoleMapper.selectById(8);
        sysRole.setRoleName("高级管理员");
        int i = sysRoleMapper.updateById(sysRole);
        System.out.println("i = " + i);
    }

    @Test
    public void testQueryWrapper() {
        QueryWrapper<SysRole> sysRoleQueryWrapper = new QueryWrapper<>();
        QueryWrapper<SysRole> sysRole = sysRoleQueryWrapper.ge("id", 9);
        System.out.println("sysRole = " + sysRole);
    }

    @Test
    public void testService() {
        System.out.println("============================selectAll method test==================================");
        List<SysRole> list = sysRoleServiceImp.list();
        list.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        ArrayList<SysRole> sysRoles = new ArrayList<>();
        Collections.addAll(sysRoles, new SysRole("null", "12", "33"), new SysRole("null", "123", "33"));
        sysRoleServiceImp.saveBatch(sysRoles, 2);
    }

    @Test
    public void testInsert01() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("饲养员");
        sysRole.setRoleCode("animal");
        sysRole.setDescription("feedAnimal");
        int insert = sysRoleMapper.insert(sysRole);
        System.out.println(insert == 1 ? "添加成功过" : "失败");
        System.out.println(sysRole.getId());
    }

    @Test
    public void testInsert02() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("技术经理4");
        sysRole.setRoleCode("animal");
        sysRole.setDescription("母猪的产后护理");
        sysRole.setId(119L);
        int insert = sysRoleMapper.insert(sysRole);
        System.out.println(insert == 1 ? "添加成功过" : "失败");
        System.out.println(sysRole.getId());
    }

    @Test
    public void test02() {
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(s);
    }

    @Test
    public void testDelete() {
        sysRoleMapper.deleteById(9);
    }

    @Test
    public void test03() {
        sysRoleMapper.deleteBatchIds(Arrays.asList(23, 24));
    }

    @Test
    public void testUpdate() {
        SysRole sysRole = new SysRole();
        sysRole.setId(19L);
        sysRole.setRoleName("饲养管理员");
        sysRoleMapper.updateById(sysRole);
    }

    @Test
    @SuppressWarnings("all")
    public void testQuery() {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("role_name","管理员").or().like("role_code","y");
        queryWrapper.like("role_code","y");

        LambdaQueryWrapper<SysRole> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.like(SysRole::getRoleName,"管理员");

        lambdaQueryWrapper.like(SysRole->SysRole.getRoleName(),"管理员");

        lambdaQueryWrapper.like(new SFunction<SysRole, Object>() {
            @Override
            public Object apply(SysRole sysRole) {
                return sysRole.getRoleName();
            }
        }, "管理员");
        List<SysRole> sysRoles = sysRoleMapper.selectList(lambdaQueryWrapper);
        sysRoles.forEach(System.out::println);
    }
    @Test
    public void testSelectPage(){
        QueryWrapper<SysRole> sysRoleQueryWrapper = new QueryWrapper<>();
        sysRoleQueryWrapper.like("role_name","管理员");
        //当前第一页每一页两个对象
        Page<SysRole> sysRolePage = new Page<>(1,2);

        Page<SysRole> page = sysRoleMapper.selectPage(sysRolePage, sysRoleQueryWrapper);
        //获取分页信息
        long pages = page.getPages();
        System.out.println("总页数pages = " + pages);
        long total = page.getTotal();
        System.out.println("总条数total = " + total);
        //当前页列表
        List<SysRole> records = page.getRecords();
        records.forEach(System.out::println);
    }
}
