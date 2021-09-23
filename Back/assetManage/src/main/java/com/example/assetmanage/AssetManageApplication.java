package com.example.assetmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main 启动类
 * @author huang jiahui
 * @date 2021/09/18
 */
@SpringBootApplication(exclude = FreeMarkerAutoConfiguration.class)
@MapperScan("com.example.assetmanage.mapper")
@EnableScheduling
public class AssetManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssetManageApplication.class, args);
    }

}
