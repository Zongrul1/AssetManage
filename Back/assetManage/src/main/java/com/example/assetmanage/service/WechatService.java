package com.example.assetmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.assetmanage.mapper.AlipayMapper;
import com.example.assetmanage.mapper.WechatMapper;
import com.example.assetmanage.model.Alipay;
import com.example.assetmanage.model.Wechat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李宗儒
 * @date 2022/3/12
 **/
@Service
public class WechatService {
    WechatMapper wechatMapper;

    TotalService totalService;

    @Autowired
    public void setTotalService(TotalService totalService) {
        this.totalService = totalService;
    }

    @Autowired
    public void setWechatMapper(WechatMapper wechatMapper) {
        this.wechatMapper = wechatMapper;
    }

    public List<Wechat> getAll(){
        return wechatMapper.selectList(new QueryWrapper<>());
    }

    public int getValue() {
        if (wechatMapper.selectCount(new QueryWrapper<>()) > 0) {
            return wechatMapper.getValue();
        }
        else{
            return 0;
        }
    }

    public Wechat insert(Wechat wechat){
        wechatMapper.insert(wechat);
        totalService.insert();
        return wechat;
    }

    public Wechat update(Wechat wechat){
        wechatMapper.updateById(wechat);
        totalService.insert();
        return wechat;
    }

    public String delete(String id){
        wechatMapper.deleteById(id);
        totalService.insert();
        return id;
    }
}
