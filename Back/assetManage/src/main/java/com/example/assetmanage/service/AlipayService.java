package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.AlipayMapper;
import com.example.assetmanage.mapper.FundMapper;
import com.example.assetmanage.model.Alipay;
import com.example.assetmanage.model.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李宗儒
 * @date 2022/3/12
 **/
@Service
public class AlipayService {
    AlipayMapper alipayMapper;

    TotalService totalService;

    @Autowired
    public void setTotalService(TotalService totalService) {
        this.totalService = totalService;
    }

    @Autowired
    public void setAlipayMapper( AlipayMapper alipayMapper) {
        this.alipayMapper = alipayMapper;
    }

    public List< Alipay> getAll(){
        return alipayMapper.selectList(new QueryWrapper<>());
    }

    public int getValue() {
        if (alipayMapper.selectCount(new QueryWrapper<>()) > 0) {
            return alipayMapper.getValue();
        }
        else{
            return 0;
        }
    }

    public Alipay insert(Alipay alipay){
        alipayMapper.insert(alipay);
        totalService.insert();
        return alipay;
    }

    public Alipay update( Alipay alipay){
        alipayMapper.updateById(alipay);
        totalService.insert();
        return alipay;
    }

    public String delete(String id){
        alipayMapper.deleteById(id);
        totalService.insert();
        return id;
    }
}
