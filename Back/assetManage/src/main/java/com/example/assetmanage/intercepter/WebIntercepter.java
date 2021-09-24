package com.example.assetmanage.intercepter;

import com.example.assetmanage.utils.TokenCache;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@AllArgsConstructor
public class WebIntercepter implements HandlerInterceptor {

    @Override
    //preHandle:在方法调用前使用
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String token = (String)request.getSession().getAttribute("token");
        String userId = (String) request.getSession().getAttribute("userId");
        Boolean isLogin = (Boolean) request.getSession().getAttribute("isLogin");

        // session 过期 token 不存在
        if(token == null){
            return false;
        }

        // 如果是登陆
        if(isLogin != null && isLogin){
            request.getSession().setAttribute("isLogin",false);
            TokenCache.setToken(userId,token);
            return true;
        }

        String tokenResult = TokenCache.getToken(userId);

        if(tokenResult == null || !tokenResult.equals(token)){
            return false;
        }

        return true;
    }
}
