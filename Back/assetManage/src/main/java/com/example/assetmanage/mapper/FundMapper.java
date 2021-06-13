package com.example.assetmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.assetmanage.model.Fund;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FundMapper extends BaseMapper<Fund> {
    @Select("select sum(value) from fund")
    int getValue();
}
