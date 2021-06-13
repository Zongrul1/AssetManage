package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.FundMapper;
import com.example.assetmanage.model.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FundService {
    FundMapper fundMapper;

    TotalService totalService;

    @Autowired
    public void setTotalService(TotalService totalService) {
        this.totalService = totalService;
    }

    @Autowired
    public void setCashMapper(FundMapper fundMapper) {
        this.fundMapper = fundMapper;
    }

    public List<Fund> getAll(){
        return fundMapper.selectList(new QueryWrapper<>());
    }

    public int getValue() {
        if (fundMapper.selectCount(new QueryWrapper<>()) > 0) {
            return fundMapper.getValue();
        }
        else{
            return 0;
        }
    }

    public Fund insert(Fund fund){
        fundMapper.insert(fund);
        totalService.insert();
        return fund;
    }

    public Fund update(Fund fund){
        fundMapper.updateById(fund);
        totalService.insert();
        return fund;
    }

    public String delete(String id){
        fundMapper.deleteById(id);
        totalService.insert();
        return id;
    }
}
