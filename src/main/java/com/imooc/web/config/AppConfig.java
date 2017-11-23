package com.imooc.web.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.annotation.PostConstruct;
import java.util.Properties;


@Configuration
public class AppConfig {


    @Autowired
    private SqlSessionFactory sqlSessionFactory;

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

    /**
     * 拦截器必须早于其他bean注入，否则PostConstrct注解不起作用
     */
    @PostConstruct
    public void addPageInterceptor(){
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("params","pageNum=pageNum;pageSize=pageSize;count=countSql;reasonable=reasonable;pageSizeZero=pageSizeZero");
        properties.setProperty("supportMethodsArguments","true");
        interceptor.setProperties(properties);
        sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
    }

}
