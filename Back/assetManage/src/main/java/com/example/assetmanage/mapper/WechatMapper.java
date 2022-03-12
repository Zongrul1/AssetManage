package com.example.assetmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.assetmanage.model.Alipay;
import com.example.assetmanage.model.Wechat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 李宗儒
 * @date 2022/3/12
 **/
@Mapper
public interface WechatMapper extends BaseMapper<Wechat> {
    @Select("select sum(value) from wechat")
    int getValue();
}
