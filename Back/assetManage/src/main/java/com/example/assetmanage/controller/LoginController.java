package com.example.assetmanage.controller;

import com.example.assetmanage.model.R;
import com.example.assetmanage.service.LoginService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;


/**
 * todo
 *
 * @author huang jiahui
 * @date 2021/9/22 9:54
 */
@RestController
@RequestMapping("/login")
@AllArgsConstructor
@Api("初始登录")
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/verify")
    public R<String> verify(String account, String password, HttpServletRequest request){
        String token = loginService.verify(account, password,request);
        return R.successed(token);
    }


}
