package com.example.assetmanage.controller;

import com.example.assetmanage.model.Alipay;
import com.example.assetmanage.model.R;
import com.example.assetmanage.model.Wechat;
import com.example.assetmanage.service.AlipayService;
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
@Api(tags = "支付宝模块")
@RequestMapping("/alipay")
@CrossOrigin
public class AlipayController {
    private AlipayService alipayService;


    @GetMapping("/get-all")
    @ApiOperation(value = "获取所有支付宝")
    public R<List<Alipay>> getAllFund() {
        return R.successed(alipayService.getAll());
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加一只支付宝")
    public R<Alipay> addFund(@RequestBody Alipay alipay) {return R.successed(alipayService.insert(alipay));}

    @PostMapping("/update")
    @ApiOperation(value = "修改一只支付宝")
    public R<Alipay> updateFund(@RequestBody Alipay alipay) {return R.successed(alipayService.update(alipay));}

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除一只支付宝")
    public R<String> deleteFund(@PathVariable("id") String id){return R.successed(alipayService.delete(id));}

    @GetMapping("/get-value")
    @ApiOperation(value = "获取所有支付宝的价值")
    public R<Integer> getFundValue() {
        return R.successed(alipayService.getValue());
    }
}
