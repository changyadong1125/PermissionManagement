package com.atguigu.springboot.service;

import com.atguigu.springboot.mapper.SysRoleMapper;
import com.atguigu.springboot.model.system.SysRole;
import com.atguigu.springboot.model.vo.SysRoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * project:PermissionManagement
 * package:com.atguigu.springboot.service
 * class:SysRoleServiceImp
 *
 * @author: smile
 * @create: 2023/4/26-18:28
 * @Version: v1.0
 * @Description:
 */
@Service
public class SysRoleServiceImp extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo roleQueryVo) {
        return sysRoleMapper.selectPage(pageParam,roleQueryVo );
    }
}
