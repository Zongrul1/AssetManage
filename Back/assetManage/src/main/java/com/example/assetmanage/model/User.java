package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 李宗儒
 * @date 2022/3/13
 **/
@Data
public class User extends Base{

    private String name;

    private String password;

    private String token;

    private String expired;

    @TableField(value = "create_time")
    private Long createTime;


}
