package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("fund")
@ApiModel(value = "fund对象", description = "fund对象")
public class Fund extends Base{
    @ApiModelProperty("基金名称")
    private String name;

    @ApiModelProperty("价值")
    private int value;
}
