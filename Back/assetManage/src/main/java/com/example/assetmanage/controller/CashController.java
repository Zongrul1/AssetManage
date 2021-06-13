package com.example.assetmanage.controller;

import com.example.assetmanage.model.Cash;
import com.example.assetmanage.model.Coin;
import com.example.assetmanage.model.R;
import com.example.assetmanage.service.CashService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Api(tags = "现金模块")
@RequestMapping("/cash")
@CrossOrigin
public class CashController {
    private CashService cashService;


    @GetMapping("/get-all")
    @ApiOperation(value = "获取所有现金")
    public R<List<Cash>> getAllCash() {
        return R.successed(cashService.getAll());
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加一只现金")
    public R<Cash> addCash(@RequestBody Cash cash) {return R.successed(cashService.insert(cash));}

    @PostMapping("/update")
    @ApiOperation(value = "修改一只现金")
    public R<Cash> updateCash(@RequestBody Cash cash) {return R.successed(cashService.update(cash));}

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除一只现金")
    public R<String> deleteCash(@PathVariable("id") String id){return R.successed(cashService.delete(id));}

    @GetMapping("/get-value")
    @ApiOperation(value = "获取所有现金的价值")
    public R<Integer> getCashValue() {
        return R.successed(cashService.getValue());
    }


}
