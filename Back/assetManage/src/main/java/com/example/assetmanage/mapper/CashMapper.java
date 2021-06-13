package com.example.assetmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.assetmanage.model.Cash;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CashMapper extends BaseMapper<Cash> {

    @Select("select sum(value) from cash")
    int getValue();
}
