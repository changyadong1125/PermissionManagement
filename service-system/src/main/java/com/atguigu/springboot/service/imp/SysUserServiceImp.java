package com.atguigu.springboot.service.imp;

import com.atguigu.springboot.mapper.SysUserMapper;
import com.atguigu.springboot.model.system.SysUser;
import com.atguigu.springboot.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * project:PermissionManagement
 * package:com.atguigu.springboot.service.imp
 * class:SysUserServiceImp
 *
 * @author: smile
 * @create: 2023/4/29-23:52
 * @Version: v1.0
 * @Description:
 */
@Service
@Transactional
public class SysUserServiceImp extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    public boolean updateStatus(Long id, Integer status) {
        SysUser sysUser = new SysUser();
        sysUser.setStatus(status);
        UpdateWrapper<SysUser> sysUserUpdateWrapper = new UpdateWrapper<>();
        sysUserUpdateWrapper.eq("id", id);
        int update = baseMapper.update(sysUser, sysUserUpdateWrapper);
        return update > 0;
    }
}
