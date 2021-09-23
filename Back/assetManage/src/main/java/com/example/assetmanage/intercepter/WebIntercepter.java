package com.example.assetmanage.intercepter;

import com.example.assetmanage.untils.TokenCache;
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

        // session 过期 token 不存在
        if(token == null){
            return false;
        }

        String tokenResult = TokenCache.getToken(userId);

        if(tokenResult == null || tokenResult.equals(token)){
            return false;
        }

        return true;
    }
}
