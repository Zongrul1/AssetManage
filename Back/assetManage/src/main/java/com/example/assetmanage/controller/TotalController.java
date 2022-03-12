package com.example.assetmanage.controller;

import com.example.assetmanage.model.EachVO;
import com.example.assetmanage.model.R;
import com.example.assetmanage.model.Total;
import com.example.assetmanage.model.TotalVO;
import com.example.assetmanage.service.TotalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Api(tags = "汇总模块")
@RequestMapping("/total")
@CrossOrigin
public class TotalController {
    private TotalService totalService;


    @GetMapping("/get-all")
    @ApiOperation(value = "获取所有资产")
    public R<List<TotalVO>> getAllAsset() {
        return R.successed(totalService.getAll());
    }

    @GetMapping("/get-each")
    @ApiOperation(value = "获取各资产占比")
    public R<List<EachVO>> getEachAsset(){
        return R.successed(totalService.getEach());
    }

    @GetMapping("/test")
    public String test(){return "ok";}
}
