package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author 李宗儒
 * @date 2022/3/13
 **/
@Data
@TableName("user")
public class User extends Base{

    private String name;

    private String password;

    private String token;

    @TableField(value = "create_time")
    private Date createTime;


}
