package com.example.assetmanage.controller;

import com.example.assetmanage.model.R;
import com.example.assetmanage.model.User;
import com.example.assetmanage.service.UserService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户controller
 * @author huang jiahui
 * @date 2021/9/18 9:43
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户模块")
@AllArgsConstructor
@CrossOrigin()
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public R<User> get(String id){
        return R.successed(userService.get(id));
    }

    @PostMapping("/add")
    public R<User> add(User user){
        return R.successed(userService.add(user));
    }

    @PutMapping("/update")
    public R<User> update(User user){
        return R.successed(userService.update(user));
    }

    @DeleteMapping("/delete/{id}")
    public R<String> delete(@PathVariable String id){
        return R.successed(userService.delete(id));
    }

    @DeleteMapping("hidden-delete/{id}")
    public R<String> hiddenDelete(@PathVariable String id){
        return R.successed(userService.hiddenDelete(id));
    }
}
