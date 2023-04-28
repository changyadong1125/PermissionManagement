package com.atguigu.springboot.controller;

import com.atguigu.springboot.common.result.Result;
import com.atguigu.springboot.model.system.SysRole;
import com.atguigu.springboot.model.vo.SysRoleQueryVo;
import com.atguigu.springboot.service.SysRoleService;
import com.atguigu.springboot.service.SysRoleServiceImp;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/admin/sysRole")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleServiceImp;

    /**
     * return:
     * author: smile
     * version: 1.0
     * description:operation执行操作方法
     */
    @ApiOperation(value = "角色列表")
    @GetMapping("/query")
    public Result<List<SysRole>> findAllAxios() {
        return Result.ok(sysRoleServiceImp.list());
    }

    /**
     * return:
     * author: smile
     * version: 1.0
     * description: 分页
     */
    @ApiOperation(value = "获取分页")
    @GetMapping("/page/{page}/{limit}")
    public Result<?> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Integer page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Integer limit,
            @ApiParam(name = "roleQueryVo", value = "查询对象", required = true) SysRoleQueryVo sysRoleQueryVo) {
        Page<SysRole> pageParam = new Page<>(page, limit);
        IPage<SysRole> pageModel = sysRoleServiceImp.selectPage(pageParam, sysRoleQueryVo);
        return Result.ok(pageModel);
    }


    /**
     * return:
     * author: smile
     * version: 1.0
     * description:通过通用service查询分页信息
     */
    @ApiOperation("角色分页查询")
    @PostMapping("/pageBy/{pageNum}/{pageSize}")
    public Result<?> page(@PathVariable Integer pageNum,
                       @PathVariable Integer pageSize,
                       @RequestBody  SysRoleQueryVo sysRoleQueryVo){
        Page<SysRole> page=new Page<>(pageNum,pageSize);
        LambdaQueryWrapper<SysRole> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(sysRoleQueryVo.getRoleName()),SysRole::getRoleName,sysRoleQueryVo.getRoleName());
        sysRoleServiceImp.page(page,queryWrapper);
        return Result.ok(page);
    }

    /**
     * return:
     * author: smile
     * version: 1.0
     * description:
     */
    @ApiOperation(value = "角色查询")
    @GetMapping("/get/{id}")
    public Result<SysRole> get(@PathVariable Long id){
        SysRole role = sysRoleServiceImp.getById(id);
       return Result.ok(role);
    }
    /**
     * return:
     * author: smile
     * version: 1.0
     * description:增
     */
    @ApiOperation("角色新增")
    @PostMapping("/update")
    public Result<SysRole> save(@RequestBody SysRole sysRole){
        sysRoleServiceImp.save(sysRole);
        return Result.ok();
    }
    /**
     * return:
     * author: smile
     * version: 1.0
     * description:删除单个
     */
    @ApiOperation("角色删除")
    @DeleteMapping("/query/{id}")
    public Result<SysRole> deleteOne(@PathVariable String id){
        sysRoleServiceImp.removeById(id);
        return Result.ok();
    }
    /**
     * return:
     * author: smile
     * version: 1.0
     * description:批量删除
     */
    @ApiOperation("角色批量删除")
    @DeleteMapping("/query")
    public Result<SysRole> deleteBatch(@RequestBody List<Long> idList){
        sysRoleServiceImp.removeByIds(idList);
        return Result.ok();
    }
    /**
     * return:
     * author: smile
     * version: 1.0
     * description:角色回显
     */
    @ApiOperation("角色回显")
    @PutMapping ("/update/{id}")
    public Result<SysRole> get(@PathVariable String id){
        SysRole sysRole = sysRoleServiceImp.getById(id);
        return Result.ok(sysRole);
    }
    /**
     * return:
     * author: smile
     * version: 1.0
     * description:修改
     */
    @ApiOperation("角色修改")
    @PutMapping("/update")
    public Result<SysRole> get(@RequestBody SysRole sysRole){
        sysRoleServiceImp.updateById(sysRole);
        return Result.ok();
    }
}
