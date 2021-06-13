package com.example.assetmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.assetmanage.model.Coin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CoinMapper extends BaseMapper<Coin> {
    @Select("select sum(value) from coin")
    int getValue();
}
