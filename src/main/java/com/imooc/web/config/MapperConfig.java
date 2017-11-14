package com.imooc.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource(value="mapper.xml")
public class MapperConfig {

}
