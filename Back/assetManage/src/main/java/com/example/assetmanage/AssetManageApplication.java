package com.example.assetmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

@SpringBootApplication(exclude = FreeMarkerAutoConfiguration.class)
@MapperScan("com.example.assetmanage.mapper")
public class AssetManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssetManageApplication.class, args);
    }

}
