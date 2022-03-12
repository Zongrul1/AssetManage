package com.example.assetmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.assetmanage.model.Alipay;
import com.example.assetmanage.model.Cash;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 李宗儒
 * @date 2022/3/12
 **/
@Mapper
public interface AlipayMapper extends BaseMapper<Alipay> {
    @Select("select sum(value) from alipay")
    int getValue();
}
