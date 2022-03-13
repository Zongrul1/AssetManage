package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.UserMapper;
import com.example.assetmanage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author 李宗儒
 * @date 2022/3/13
 **/
@Service
public class UserService {

    UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String login(User userTemp){
        User user = userMapper.selectOne(
                new QueryWrapper<User>()
                .eq("name",userTemp.getName())
                .eq("password",userTemp.getPassword())
        );
        //无用户的情况
        if(user == null){
            return null;
        }
        //每次登录更新
        user.setToken(getRandomString(10));
        userMapper.updateById(user);
        return user.getToken();
    }

    public String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
