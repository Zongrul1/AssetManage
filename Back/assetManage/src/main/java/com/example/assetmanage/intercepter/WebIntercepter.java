package com.example.assetmanage.intercepter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.UserMapper;
import com.example.assetmanage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class WebIntercepter implements HandlerInterceptor {

    @Autowired
    UserMapper userMapper;


    @Override
    //preHandle:在方法调用前使用
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println(request.getHeaderNames());
        String token = request.getHeader("token");
        Long now = System.currentTimeMillis();
        User user = userMapper.selectOne(
                new QueryWrapper<User>()
                .eq("token",token)
        );
        //不存在的情况
        if(user == null){
            return false;
        }
        else {
            //过期
            if(now - user.getCreateTime() >= 86400){
                return false;
            }
            else{
                return true;
            }
        }
    }
}
