package com.atguigu.springboot.controller;

import com.atguigu.springboot.common.result.Result;
import com.atguigu.springboot.model.system.SysUser;
import com.atguigu.springboot.model.vo.SysRoleQueryVo;
import com.atguigu.springboot.model.vo.SysUserQueryVo;
import com.atguigu.springboot.service.SysRoleService;
import com.atguigu.springboot.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.Objects;

/**
 * project:PermissionManagement
 * package:com.atguigu.springboot.controller
 * class:sysUserController
 *
 * @author: smile
 * @create: 2023/5/4-18:00
 * @Version: v1.0
 * @Description:
 */
@RestController
@Api(tags="用户管理")
@RequestMapping("/admin/system/sysUser")
public class sysUserController {
    @Resource
    private SysUserService sysUserServiceImp;

    @GetMapping("/{page}/{limit}")
    @ApiOperation("用户分页查询")
    public Result<?> pageList(
            @ApiParam("当前页") @PathVariable Integer page,
            @ApiParam("每页条数")  @PathVariable Integer limit,
            @ApiParam("查询条件") SysUserQueryVo sysUserQueryVo
            ){
        Page<SysUser> sysUserPage = new Page<>(page,limit);
        QueryWrapper<SysUser> sysUserQueryWrapper = new QueryWrapper<>();
        sysUserQueryWrapper.like(!StringUtils.isEmpty(sysUserQueryVo.getKeyword()),"username",sysUserQueryVo.getKeyword());
        sysUserServiceImp.page(sysUserPage,sysUserQueryWrapper);
        return Result.ok(sysUserPage);
    }
}
