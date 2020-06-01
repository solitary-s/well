package com.aloneness.well.framework.config;

import com.aloneness.well.framework.response.ApiControllerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * well config配置
 *
 * @author: tong
 * @create: 2020-06-01 20:34
 */
@Configuration
@Slf4j
public class WellBeanConfig {

    @Bean
    @ConditionalOnMissingBean(ApiControllerAdvice.class)
    public ApiControllerAdvice apiControllerAdvice(){
        log.info("开启controller返回类型包装");
        return new ApiControllerAdvice();
    }
}
