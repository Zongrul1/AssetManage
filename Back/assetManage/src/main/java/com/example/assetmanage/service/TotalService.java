package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.*;
import com.example.assetmanage.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TotalService {
    TotalMapper totalMapper;
    StockMapper stockMapper;
    CashMapper cashMapper;
    CoinMapper coinMapper;
    FundMapper fundMapper;
    AlipayMapper alipayMapper;
    WechatMapper wechatMapper;

    @Autowired
    public void setTotalMapper(TotalMapper totalMapper) {
        this.totalMapper = totalMapper;
    }

    @Autowired
    public void setCashMapper(CashMapper cashMapper) {
        this.cashMapper = cashMapper;
    }

    @Autowired
    public void setCoinMapper(CoinMapper coinMapper) {
        this.coinMapper = coinMapper;
    }

    @Autowired
    public void setFundMapper(FundMapper fundMapper) {
        this.fundMapper = fundMapper;
    }

    @Autowired
    public void setStockMapper(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }

    @Autowired
    public void setAlipayMapper(AlipayMapper alipayMapper) {
        this.alipayMapper = alipayMapper;
    }

    @Autowired
    public void setWechatMapper(WechatMapper wechatMapper) {
        this.wechatMapper = wechatMapper;
    }

    public List<TotalVO> getAll(){
        return totalMapper.selectList(new QueryWrapper<Total>().orderByAsc("date")).stream().map(this::tranferToTotalVO)
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
        if(alipayMapper.selectCount(new QueryWrapper<>()) > 0){
            value += alipayMapper.getValue();
        }
        if(wechatMapper.selectCount(new QueryWrapper<>()) > 0){
            value += wechatMapper.getValue();
        }
        if(cashMapper.selectCount(new QueryWrapper<>()) > 0){
            value += cashMapper.getValue();
        }
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        f.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        Total total = new Total(value,date);
        System.out.println("现在的日期是:" + f.format(date));
        if(totalMapper.selectCount(new QueryWrapper<Total>().eq("date",f.format(date))) == 0){
            totalMapper.insert(total);
        }
        else{
            total = totalMapper.selectOne(new QueryWrapper<Total>().eq("date",f.format(date)));
            total.setValue(value);
            System.out.println("现在的价值是：" + value);
            totalMapper.updateById(total);
        }

        return total;
    }

    public List<EachVO> getEach(){
        List<EachVO> eachVOList = new LinkedList<>();
        //处理股票对象
        EachVO stock = new EachVO();
        stock.setName("股票");
        if(stockMapper.selectCount(new QueryWrapper<>()) > 0){
            stock.setValue(stockMapper.getValue());
        }
        else {
            stock.setValue(0);
        }
        eachVOList.add(stock);
        //处理数字货币对象
        EachVO coin = new EachVO();
        coin.setName("数字货币");
        if(coinMapper.selectCount(new QueryWrapper<>()) > 0){
            coin.setValue(coinMapper.getValue());
        }
        else {
            coin.setValue(0);
        }
        eachVOList.add(coin);
        //处理支付宝对象
        EachVO alipay = new EachVO();
        alipay.setName("支付宝");
        if(alipayMapper.selectCount(new QueryWrapper<>()) > 0){
            alipay.setValue(alipayMapper.getValue());
        }
        else {
            alipay.setValue(0);
        }
        eachVOList.add(alipay);
        //处理微信对象
        EachVO wechat = new EachVO();
        wechat.setName("微信");
        if(wechatMapper.selectCount(new QueryWrapper<>()) > 0){
            wechat.setValue(wechatMapper.getValue());
        }
        else {
            wechat.setValue(0);
        }
        eachVOList.add(wechat);
        //处理现金对象
        EachVO cash = new EachVO();
        if(cashMapper.selectCount(new QueryWrapper<>()) > 0){
            cash.setValue(cashMapper.getValue());
        }
        else {
            cash.setValue(0);
        }
        eachVOList.add(cash);
        return eachVOList;
    }

    public TotalVO tranferToTotalVO(Total total){
        TotalVO totalVO = new TotalVO();
        BeanUtils.copyProperties(total,totalVO);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        totalVO.setDate(f.format(total.getDate()));
        return totalVO;
    }
}
