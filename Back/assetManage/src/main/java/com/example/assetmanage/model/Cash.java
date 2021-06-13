package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("cash")
@ApiModel(value = "cash对象", description = "cash对象")
public class Cash extends Base{

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("价值")
    private int value;
}
