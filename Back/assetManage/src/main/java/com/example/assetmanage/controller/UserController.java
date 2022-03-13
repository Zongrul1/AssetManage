package com.example.assetmanage.controller;

import com.example.assetmanage.model.R;
import com.example.assetmanage.model.TotalVO;
import com.example.assetmanage.model.User;
import com.example.assetmanage.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李宗儒
 * @date 2022/3/13
 **/
@RestController
@AllArgsConstructor
@Api(tags = "汇总模块")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public R<String> login(@RequestBody User user) {
        String token = userService.login(user);
        if(token == null){
            return R.faild("登陆失败");
        }
        return R.successed(token);
    }
}
