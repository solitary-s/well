package com.aloneness.well.framework.config;

import com.aloneness.well.framework.response.ApiControllerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * weil framework配置
 *
 * @author aloneness
 */
@Configuration
@Slf4j
public class WellFrameworkConfig {

    @Bean
    @ConditionalOnMissingBean(ApiControllerAdvice.class)
    public ApiControllerAdvice apiControllerAdvice(){
        log.info("开启controller返回数据包装");
        return new ApiControllerAdvice();
    }
}
