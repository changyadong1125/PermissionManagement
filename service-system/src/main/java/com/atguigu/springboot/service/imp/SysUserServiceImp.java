package com.atguigu.springboot.service.imp;

import com.atguigu.springboot.mapper.SysUserMapper;
import com.atguigu.springboot.model.system.SysUser;
import com.atguigu.springboot.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class SysUserServiceImp extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
