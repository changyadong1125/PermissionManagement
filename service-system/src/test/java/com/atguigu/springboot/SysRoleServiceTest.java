package com.atguigu.springboot;

import com.atguigu.springboot.model.system.SysRole;
import com.atguigu.springboot.service.SysRoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * project:PermissionManagement
 * package:com.atguigu.springboot
 * class:SysRoleServiceTest
 *
 * @author: smile
 * @create: 2023/4/27-14:04
 * @Version: v1.0
 * @Description:
 */
@SpringBootTest
public class SysRoleServiceTest {
    @Resource
    private SysRoleService sysRoleServiceImp;

    @Test
    public void testList(){
        List<SysRole> list = sysRoleServiceImp.list();
        list.forEach(System.out::println);
    }
    @Test
    public void testPage(){
        Page<SysRole> sysRolePage = new Page<>(1,2);
        QueryWrapper<SysRole> sysRoleQueryWrapper = new QueryWrapper<>();
        QueryWrapper<SysRole> wrapper = sysRoleQueryWrapper.like("role_name", "管理员");
        sysRoleServiceImp.page(sysRolePage,wrapper);
        System.out.println("总页数"+sysRolePage.getPages());
        System.out.println("总记录数"+sysRolePage.getTotal());
        System.out.println("当前页列表"+sysRolePage.getRecords());
    }
    @Test
    public void testUpdate(){
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("坤坤最美");
        UpdateWrapper<SysRole> sysRoleUpdateWrapper = new UpdateWrapper<>();
        UpdateWrapper<SysRole> wrapper = sysRoleUpdateWrapper.eq("role_code", "animal");
        sysRoleServiceImp.update(sysRole,wrapper);
    }
}
