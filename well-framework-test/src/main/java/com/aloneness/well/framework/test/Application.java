package com.aloneness.well.framework.test;

import com.aloneness.well.framework.config.EnableWellFramework;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 入口
 *
 * @author
 */
@SpringBootApplication
@EnableWellFramework
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
