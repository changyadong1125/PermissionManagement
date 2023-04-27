package com.atguigu.springboot.controller;

import com.atguigu.springboot.common.result.Result;
import com.atguigu.springboot.model.system.SysRole;
import com.atguigu.springboot.model.vo.SysRoleQueryVo;
import com.atguigu.springboot.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * project:PermissionManagement
 * package:com.atguigu.springboot.controller
 * class:SysRoleController
 *
 * @author: smile
 * @create: 2023/4/26-19:04
 * @Version: v1.0
 * @Description:
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleServiceImp;

    /**
     * return:
     * author: smile
     * version: 1.0
     * description:
     */
    @ApiOperation(value = "获取全部角色列表")
    @GetMapping("/findAll")
    public Result<List<SysRole>> findAllAxios() {
        return Result.ok(sysRoleServiceImp.list());
    }

    /**
     * return:
     * author: smile
     * version: 1.0
     * description:
     */
    @ApiOperation(value = "获取分页")
    @GetMapping("/{page}/{limit}")
    public Result<?> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "roleQueryVo", value = "查询对象", required = true) SysRoleQueryVo sysRoleQueryVo) {
        Page<SysRole> pageParam = new Page<>(page, limit);
        IPage<SysRole> pageModel = sysRoleServiceImp.selectPage(pageParam, sysRoleQueryVo);
        return Result.ok(pageModel);
    }

    /**
     * return:
     * author: smile
     * version: 1.0
     * description:
     */
    @ApiOperation(value = "获取角色")
    @GetMapping("/get/{id}")
    public Result<SysRole> get(@PathVariable Long id){
        int a = 10/0;
        SysRole role = sysRoleServiceImp.getById(id);
       return Result.ok(role);
    }
}
