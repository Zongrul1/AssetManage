package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

@Data
@TableName("stock")
@ApiModel(value = "Stock对象", description = "Stock对象")
public class Stock extends Base{

    @ApiModelProperty("股票名称")
    private String name;

    @ApiModelProperty("股票价值")
    private int value;

}
