package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.CoinMapper;
import com.example.assetmanage.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService {

    CoinMapper coinMapper;

    TotalService totalService;

    @Autowired
    public void setTotalService(TotalService totalService) {
        this.totalService = totalService;
    }

    @Autowired
    public void setCashMapper(CoinMapper coinMapper) {
        this.coinMapper = coinMapper;
    }

    public List<Coin> getAll(){
        return coinMapper.selectList(new QueryWrapper<>());
    }

    public int getValue() {
        if (coinMapper.selectCount(new QueryWrapper<>()) > 0) {
            return coinMapper.getValue();
        }
        else{
            return 0;
        }
    }

    public Coin insert(Coin coin){
        coinMapper.insert(coin);
        totalService.insert();
        return coin;
    }

    public Coin update(Coin coin){
        coinMapper.updateById(coin);
        totalService.insert();
        return coin;
    }

    public String delete(String id){
        coinMapper.deleteById(id);
        totalService.insert();
        return id;
    }
}
