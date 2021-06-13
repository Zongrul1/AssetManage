package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.CashMapper;
import com.example.assetmanage.model.Cash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashService {

    CashMapper cashMapper;

    TotalService totalService;

    @Autowired
    public void setTotalService(TotalService totalService) {
        this.totalService = totalService;
    }

    @Autowired
    public void setCashMapper(CashMapper cashMapper) {
        this.cashMapper = cashMapper;
    }

    public List<Cash> getAll(){
        return cashMapper.selectList(new QueryWrapper<>());
    }

    public int getValue() {
        if (cashMapper.selectCount(new QueryWrapper<>()) > 0) {
            return cashMapper.getValue();
        }
        else{
            return 0;
        }
    }

    public Cash insert(Cash cash){
        cashMapper.insert(cash);
        totalService.insert();
        return cash;
    }

    public Cash update(Cash cash){
        cashMapper.updateById(cash);
        totalService.insert();
        return cash;
    }

    public String delete(String id){
        cashMapper.deleteById(id);
        totalService.insert();
        return id;
    }
}
