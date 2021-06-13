package com.example.assetmanage.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("Result")
public class R<T> implements Serializable {
    public static final Integer CODE_SUCCESSED = 200;
    public static final Integer CODE_ERROR = 500;


    /**
     * 结果状态码
     */
    @ApiModelProperty("状态码")
    private Integer status;
    /**
     * 结果信息
     */
    @ApiModelProperty("信息")
    private String message;



    /**
     * 结果返回的数据
     */
    @ApiModelProperty("数据")
    private T data;


    public R(Integer status, String message,T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    public static<T> R<T> successed(T data) {
        return new R<T> (CODE_SUCCESSED, "success",data);
    }

    public static<T> R faild(T data) {
        return new R (CODE_ERROR, "运行时出错.",data);
    }

}
