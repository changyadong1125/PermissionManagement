package com.atguigu.springboot.service;

import com.atguigu.springboot.model.system.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * project:PermissionManagement
 * package:com.atguigu.springboot.service
 * class:SysUserImp
 *
 * @author: smile
 * @create: 2023/4/29-23:48
 * @Version: v1.0
 * @Description:
 */
public interface SysUserService extends IService<SysUser> {
     boolean updateStatus(Long id, Integer status) ;
}
