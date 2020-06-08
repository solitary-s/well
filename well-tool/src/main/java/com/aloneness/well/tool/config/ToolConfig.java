package com.aloneness.well.tool.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author liaoshitong
 * @date 2020/6/8
 */
@Configuration
@EnableConfigurationProperties(GenConfig.class)
@MapperScan(ToolConfig.BASE_DAO_PACKAGE)
public class ToolConfig {

    public static final String BASE_DAO_PACKAGE = "com.aloneness.well.tool.**.mapper";
}
