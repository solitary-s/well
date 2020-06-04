package com.aloneness.well.framework.test.config;

import com.aloneness.well.framework.test.exception.TestException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Test 配置
 *
 * @author liaoshitong
 * @date 2020/6/4
 */
@Configuration
public class TestConfig {

    @Bean
    public TestException testException() {
        return new TestException();
    }
}
