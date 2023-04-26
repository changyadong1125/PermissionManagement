package com.atguigu.springboot.model.system;


import com.atguigu.springboot.model.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "角色")
//和表名映射
@TableName("sys_role")
public class SysRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	//@NotBlank(message = "角色名称不能为空")
	@ApiModelProperty(value = "角色名称")
	//属性和字段映射
	@TableField("role_name")
	private String roleName;

	@ApiModelProperty(value = "角色编码")
	@TableField("role_code")
	private String roleCode;

	@ApiModelProperty(value = "描述")
	@TableField("description")
	private String description;

}

