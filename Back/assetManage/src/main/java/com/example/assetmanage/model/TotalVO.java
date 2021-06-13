package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TotalVO {
    @ApiModelProperty("价值")
    private int value;

    @ApiModelProperty("时间")
    private String date;
}
