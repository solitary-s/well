package com.aloneness.well.framework.config;

import com.aloneness.well.framework.properties.WellProperties;
import com.aloneness.well.framework.response.ApiControllerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

/**
 * well config配置
 *
 * @author: tong
 * @create: 2020-06-01 20:34
 */
@Configuration
@Slf4j
public class WellBeanConfig {

    /**
     * 统一的返回类型包装
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(ApiControllerAdvice.class)
    public ApiControllerAdvice apiControllerAdvice(){
        log.info("开启controller返回类型包装");
        return new ApiControllerAdvice();
    }

    /**
     * 跨域支持
     *
     * @param wellProperties
     * @return
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(WellProperties wellProperties) {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Collections.singletonList(CorsConfiguration.ALL));
        corsConfiguration.setAllowedHeaders(Collections.singletonList(CorsConfiguration.ALL));
        corsConfiguration.setAllowedMethods(Collections.singletonList(CorsConfiguration.ALL));
        corsConfiguration.addExposedHeader(wellProperties.getCross().getAccessControlAllowHeaders());
        source.registerCorsConfiguration(wellProperties.getCross().getPathPatterns(), corsConfiguration);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        log.info("开启全局跨域支持");
        return bean;
    }
}
