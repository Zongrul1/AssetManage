package com.example.assetmanage;

import com.example.assetmanage.config.Knife4jConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = FreeMarkerAutoConfiguration.class)
@MapperScan("com.example.assetmanage.mapper")
public class AssetManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssetManageApplication.class, args);
    }

}
