package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.tracing.dtrace.ArgsAttributes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("total")
@ApiModel(value = "total对象",description = "total对象")
@AllArgsConstructor
@NoArgsConstructor
public class Total extends Base{

    @ApiModelProperty("价值")
    private int value;

    @ApiModelProperty("时间")
    @TableField(fill = FieldFill.INSERT)
    private Date date;
}
