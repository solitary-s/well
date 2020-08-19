package com.aloneness.well.tool.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liaoshitong
 * @date 2020/6/8
 */
@Configuration
@EnableConfigurationProperties(GenConfig.class)
@MapperScan(ToolConfig.BASE_DAO_PACKAGE)
public class ToolConfig implements WebMvcConfigurer {

    public static final String BASE_DAO_PACKAGE = "com.aloneness.well.tool.**.mapper";

    @Value("${well.image.path}")
    private String imagePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler( "/image/**").addResourceLocations("file:" + imagePath);
    }
}
