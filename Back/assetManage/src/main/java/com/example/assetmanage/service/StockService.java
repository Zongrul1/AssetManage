package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.StockMapper;
import com.example.assetmanage.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    StockMapper stockMapper;
    TotalService totalService;

    @Autowired
    public void setTotalService(TotalService totalService) {
        this.totalService = totalService;
    }

    @Autowired
    public void setStockMapper(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }

    public int getValue() {
        if (stockMapper.selectCount(new QueryWrapper<>()) > 0) {
            return stockMapper.getValue();
        }
        else{
            return 0;
        }
    }

    public List<Stock> getAll(){
        return stockMapper.selectList(new QueryWrapper<>());
    }

    public Stock insert(Stock stock){
        stockMapper.insert(stock);
        totalService.insert();
        return stock;
    }

    public Stock update(Stock stock){
        stockMapper.updateById(stock);
        totalService.insert();
        return stock;
    }

    public String delete(String id){
        stockMapper.deleteById(id);
        totalService.insert();
        return id;
    }
}
