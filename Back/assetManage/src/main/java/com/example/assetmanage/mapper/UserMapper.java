package com.example.assetmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.assetmanage.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 李宗儒
 * @date 2022/3/13
 **/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
