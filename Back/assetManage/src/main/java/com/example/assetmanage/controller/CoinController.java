package com.example.assetmanage.controller;

import com.example.assetmanage.model.Coin;
import com.example.assetmanage.model.R;
import com.example.assetmanage.service.CoinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Api(tags = "数字货币模块")
@RequestMapping("/coin")
@CrossOrigin
public class CoinController {
    private CoinService coinService;


    @GetMapping("/get-all")
    @ApiOperation(value = "获取所有货币")
    public R<List<Coin>> getAllCoin() {
        return R.successed(coinService.getAll());
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加一只货币")
    public R<Coin> addCoin(@RequestBody Coin coin) {return R.successed(coinService.insert(coin));}

    @PostMapping("/update")
    @ApiOperation(value = "修改一只货币")
    public R<Coin> updateCoin(@RequestBody Coin coin) {return R.successed(coinService.update(coin));}

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除一只货币")
    public R<String> deleteCoin(@PathVariable("id") String id){return R.successed(coinService.delete(id));}

    @GetMapping("/get-value")
    @ApiOperation(value = "获取所有货币的价值")
    public R<Integer> getCoinValue() {
        return R.successed(coinService.getValue());
    }
}
