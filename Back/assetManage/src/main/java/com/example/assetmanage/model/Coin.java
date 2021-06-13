package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("coin")
@ApiModel(value = "coin对象", description = "coin对象")
public class Coin extends Base{
    @ApiModelProperty("货币名称")
    private String name;

    @ApiModelProperty("价值")
    private int value;
}
