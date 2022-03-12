package com.example.assetmanage.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 李宗儒
 * @date 2022/3/12
 **/
@Data
@TableName("alipay")
public class Alipay extends Base{
        @ApiModelProperty("名称")
        private String name;

        @ApiModelProperty("价值")
        private int value;
}
