package com.atguigu.springboot.service.imp;

import com.atguigu.springboot.common.result.ResultCodeEnum;
import com.atguigu.springboot.custom.CustomUser;
import com.atguigu.springboot.exception.MyException;
import com.atguigu.springboot.model.system.SysUser;
import com.atguigu.springboot.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * project:PermissionManagement
 * package:com.atguigu.springboot.service.imp
 * class:UserDetailsServiceImpl
 *
 * @author: smile
 * @create: 2023/5/8-16:43
 * @Version: v1.0
 * @Description:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private SysUserService sysUserServiceImp;

    /**
     * return:
     * author: smile
     * version: 1.0
     * description:前端传过来的用户名
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<SysUser> sysUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
        sysUserLambdaQueryWrapper.eq(SysUser::getUsername, username);
        SysUser sysUser = sysUserServiceImp.getOne(sysUserLambdaQueryWrapper);
        if (sysUser == null) {
            throw new MyException(ResultCodeEnum.ACCOUNT_ERROR);
        }
        if (sysUser.getStatus() == 0) {
            throw new MyException(ResultCodeEnum.ACCOUNT_STOP);
        }
        return new CustomUser(sysUser, Collections.emptyList());
    }
}
