package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * todo
 *
 * @author huang jiahui
 * @date 2021/9/22 9:55
 */
@Data
@TableName("token")
@ApiModel(value = "login对象",description = "login对象")
public class Login extends Base{

    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("token")
    private String userToken;
    @ApiModelProperty("过期时间")
    private Date expireTime;
}
