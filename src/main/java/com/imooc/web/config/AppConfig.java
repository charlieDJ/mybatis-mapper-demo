package com.imooc.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;


@Configuration
public class AppConfig {


    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer(){
        Properties properties = new Properties();
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setMarkerInterface(tk.mybatis.mapper.common.Mapper.class);
        mapperScannerConfigurer.setBasePackage("com.**.dao");
        properties.setProperty("mappers","tk.mybatis.mapper.common.Mapper");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}
