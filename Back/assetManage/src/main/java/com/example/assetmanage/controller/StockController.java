package com.example.assetmanage.controller;

import com.example.assetmanage.model.R;
import com.example.assetmanage.model.Stock;
import com.example.assetmanage.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Api(tags = "股票模块")
@RequestMapping("/stock")
@CrossOrigin
public class StockController {
    private StockService stockService;


    @GetMapping("/get-all")
    @ApiOperation(value = "获取所有股票")
    public R<List<Stock>> getAllStock() {
        return R.successed(stockService.getAll());
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加一只股票")
    public R<Stock> addStock(@RequestBody Stock stock) {return R.successed(stockService.insert(stock));}

    @PostMapping("/update")
    @ApiOperation(value = "修改一只股票")
    public R<Stock> updateStock(@RequestBody Stock stock) {return R.successed(stockService.update(stock));}

    @GetMapping("/delete/{id}")
    @ApiOperation(value = "删除一只股票")
    public R<String> deleteStock(@PathVariable("id") String id){return R.successed(stockService.delete(id));}

    @GetMapping("/get-value")
    @ApiOperation(value = "获取所有股票的价值")
    public R<Integer> getStockValue() {
        return R.successed(stockService.getValue());
    }
}
