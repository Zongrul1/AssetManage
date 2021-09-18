package com.example.assetmanage.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.assetmanage.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户mapper
 * @author huang jiahui
 * @date 2021/9/18 10:01
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
