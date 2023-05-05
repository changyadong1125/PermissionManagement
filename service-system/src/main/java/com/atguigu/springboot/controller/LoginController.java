package com.atguigu.springboot.controller;

import com.atguigu.springboot.common.result.Result;
import com.atguigu.springboot.common.util.MD5;
import com.atguigu.springboot.model.system.SysRole;
import com.atguigu.springboot.model.system.SysUser;
import com.atguigu.springboot.model.vo.LoginVo;
import com.atguigu.springboot.service.SysRoleService;
import com.atguigu.springboot.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * project:PermissionManagement
 * package:com.atguigu.springboot
 * class:indexController
 *
 * @author: smile
 * @create: 2023/4/28-17:12
 * @Version: v1.0
 * @Description:
 */
@Api(tags = "后台登录管理")
@RestController
@RequestMapping("/admin/system")
public class LoginController {
    @Resource
    private SysUserService sysUserServiceImp;
    /**
     * return:
     * author: smile
     * version: 1.0
     * description；用户登录
     */
//    @ApiOperation("用户登录")
//    @PostMapping("/login")
//    public Result<Map<String, Object>> ok(@RequestBody Map<String, Object> map) {
//        System.out.println(map);
//        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq(!map.isEmpty(),"username",map.get("username"));
//        queryWrapper.eq(!map.isEmpty(),"password", MD5.encrypt((String)map.get("password")));
//        Map<String, Object> sysUserMap = sysUserServiceImp.getMap(queryWrapper);
//        Map<String, Object> ResMap = new HashMap<>();
//        if (sysUserMap!=null){
//            ResMap.put("token", "admin_success");
//            return Result.ok(ResMap);
//        }else{
//            ResMap.put("token", "用户不存在");
//            return Result.fail(ResMap);
//        }
//    }
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<Map<String, Object>> ok(@RequestBody LoginVo loginVo) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(!StringUtils.isEmpty(loginVo.getUsername()),"username",loginVo.getUsername());
        queryWrapper.eq(!StringUtils.isEmpty(loginVo.getPassword()),"password", MD5.encrypt(loginVo.getPassword()));
        Map<String, Object> sysUserMap = sysUserServiceImp.getMap(queryWrapper);
        Map<String, Object> ResMap = new HashMap<>();
        if (sysUserMap!=null){
            ResMap.put("token", "admin_success");
            return Result.ok(ResMap);
        }else{
            ResMap.put("token", "用户不存在");
            return Result.fail(ResMap);
        }
    }

    @ApiOperation("登录信息")
    @GetMapping("/info")
    public Result<Map<String, Object>> info(String s) {
        System.out.println("s = " + s);
        Map<String, Object> map = new HashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("admin");
        map.put("roles", strings);
        map.put("introduction", " I am a nice person");
        map.put("avatar", "https://img.zcool.cn/community/016f5d5b84ef77a8012190f27a8c13.gif");
        map.put("name", "admin");
        return Result.ok(map);
    }

    @ApiOperation("退出登录")
    @PostMapping("/logout")
    public Result<Map<String, Object>> logout() {
        return Result.ok();
    }
}
