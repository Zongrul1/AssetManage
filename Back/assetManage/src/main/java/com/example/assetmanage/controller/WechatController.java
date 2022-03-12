package com.example.assetmanage.controller;

import com.example.assetmanage.model.Fund;
import com.example.assetmanage.model.R;
import com.example.assetmanage.model.Wechat;
import com.example.assetmanage.service.WechatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 李宗儒
 * @date 2022/3/12
 **/
@RestController
@AllArgsConstructor
@Api(tags = "微信模块")
@RequestMapping("/wechat")
@CrossOrigin
public class WechatController {
    private WechatService wechatService;


    @GetMapping("/get-all")
    @ApiOperation(value = "获取所有微信")
    public R<List<Wechat>> getAllFund() {
        return R.successed(wechatService.getAll());
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加一只微信")
    public R<Wechat> addFund(@RequestBody Wechat wechat) {return R.successed(wechatService.insert(wechat));}

    @PostMapping("/update")
    @ApiOperation(value = "修改一只微信")
    public R<Wechat> updateFund(@RequestBody Wechat wechat) {return R.successed(wechatService.update(wechat));}

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除一只微信")
    public R<String> deleteFund(@PathVariable("id") String id){return R.successed(wechatService.delete(id));}

    @GetMapping("/get-value")
    @ApiOperation(value = "获取所有微信的价值")
    public R<Integer> getFundValue() {
        return R.successed(wechatService.getValue());
    }
}
