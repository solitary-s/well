package com.aloneness.well.tool;

import com.aloneness.well.framework.config.EnableWellFramework;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liaoshitong
 * @date 2020/6/8
 */
@SpringBootApplication
@EnableWellFramework
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
