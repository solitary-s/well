package com.aloneness.well.framework.config;

import com.aloneness.well.framework.exception.WellHandlerExceptionResolver;
import com.aloneness.well.framework.properties.WellProperties;
import com.aloneness.well.framework.util.JacksonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * weil framework配置
 *
 * @author aloneness
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(WellProperties.class)
public class WellFrameworkConfig implements WebMvcConfigurer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WellHandlerExceptionResolver wellHandlerExceptionResolver;

    /**
     * HTTP消息转换器
     * 注意：converters中有String类型的装换器  public String 会默认使用这个装换器，
     * 使用MappingJackson2HttpMessageConverter装换器，需要装换一下
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    }

    /**
     * Json序列化
     * 时间格式化 LocalDateTime localDateTime;
     *           LocalDate localDate;
     *           LocalTime localTime;
     * Long类型序列化
     *           Long -> String
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.forEach(JacksonUtil.wrapperObjectMapper());
    }

    /**
     * 全局异常处理
     *
     * @param resolvers
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(wellHandlerExceptionResolver);
        log.info("开启全局异常处理");
    }
}
