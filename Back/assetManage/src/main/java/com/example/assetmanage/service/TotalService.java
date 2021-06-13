package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.*;
import com.example.assetmanage.model.Stock;
import com.example.assetmanage.model.Total;
import com.example.assetmanage.model.TotalVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TotalService {
    TotalMapper totalMapper;
    StockMapper stockMapper;
    CashMapper cashMapper;
    CoinMapper coinMapper;
    FundMapper fundMapper;

    @Autowired
    public void setTotalMapper(TotalMapper totalMapper) {
        this.totalMapper = totalMapper;
    }

    @Autowired
    public void setCashMapper(CashMapper cashMapper) {
        this.cashMapper = cashMapper;
    }

    @Autowired
    public void setCashMapper(CoinMapper coinMapper) {
        this.coinMapper = coinMapper;
    }

    @Autowired
    public void setCashMapper(FundMapper fundMapper) {
        this.fundMapper = fundMapper;
    }

    @Autowired
    public void setStockMapper(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }

    public List<TotalVO> getAll(){
        return totalMapper.selectList(new QueryWrapper<Total>().orderByDesc("date")).stream().map(this::tranferToTotalVO)
                .collect(Collectors.toList());
    }

    public Total insert(){
        int value = 0;
        if(stockMapper.selectCount(new QueryWrapper<>()) > 0){
            value += stockMapper.getValue();
        }
        if(coinMapper.selectCount(new QueryWrapper<>()) > 0){
            value += coinMapper.getValue();
        }
        if(fundMapper.selectCount(new QueryWrapper<>()) > 0){
            value += fundMapper.getValue();
        }
        if(cashMapper.selectCount(new QueryWrapper<>()) > 0){
            value += cashMapper.getValue();
        }
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Total total = new Total(value,date);
        if(totalMapper.selectCount(new QueryWrapper<Total>().eq("date",f.format(date))) == 0){
            totalMapper.insert(total);
        }
        else{
            total = totalMapper.selectOne(new QueryWrapper<Total>().eq("date",f.format(date)));
            total.setValue(value);
            totalMapper.updateById(total);
        }

        return total;
    }

    public TotalVO tranferToTotalVO(Total total){
        TotalVO totalVO = new TotalVO();
        BeanUtils.copyProperties(total,totalVO);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        totalVO.setDate(f.format(total.getDate()));
        return totalVO;
    }
}
