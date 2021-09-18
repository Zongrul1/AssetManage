package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 * @author huang jiahui
 * @date 2021/9/18 9:45
 */
@Data
@TableName("user")
@ApiModel(value = "用户对象",description = "用户对象")
public class User extends Base{

    @ApiModelProperty(value = "账户")
    private String account;
    @ApiModelProperty(value = "密码")
    private String password;
    @ApiModelProperty(value = "出生日期")
    private Date birthday;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "是否删除 0未删除 1删除")
    private Integer deleted;
}
