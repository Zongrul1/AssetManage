package com.example.assetmanage.controller;


import com.example.assetmanage.model.Coin;
import com.example.assetmanage.model.Fund;
import com.example.assetmanage.model.R;
import com.example.assetmanage.service.CoinService;
import com.example.assetmanage.service.FundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Api(tags = "基金模块")
@RequestMapping("/fund")
@CrossOrigin
public class FundController {
    private FundService fundService;


    @GetMapping("/get-all")
    @ApiOperation(value = "获取所有基金")
    public R<List<Fund>> getAllFund() {
        return R.successed(fundService.getAll());
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加一只基金")
    public R<Fund> addFund(@RequestBody Fund fund) {return R.successed(fundService.insert(fund));}

    @PostMapping("/update")
    @ApiOperation(value = "修改一只基金")
    public R<Fund> updateFund(@RequestBody Fund fund) {return R.successed(fundService.update(fund));}

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除一只基金")
    public R<String> deleteFund(@PathVariable("id") String id){return R.successed(fundService.delete(id));}

    @GetMapping("/get-value")
    @ApiOperation(value = "获取所有基金的价值")
    public R<Integer> getFundValue() {
        return R.successed(fundService.getValue());
    }
}
