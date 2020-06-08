package com.aloneness.well.tool.util;

import com.aloneness.well.common.constants.WellConstants;
import org.apache.velocity.app.Velocity;

import java.util.Properties;

/**
 * @author liaoshitong
 * @date 2020/6/8
 */
public class VelocityInitializer {
    /**
     * 初始化vm方法
     */
    public static void initVelocity() {
        Properties p = new Properties();
        try {
            // 加载classpath目录下的vm文件
            p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            // 定义字符集
            p.setProperty(Velocity.ENCODING_DEFAULT, WellConstants.UTF8);
            p.setProperty(Velocity.OUTPUT_ENCODING, WellConstants.UTF8);
            // 初始化Velocity引擎，指定配置Properties
            Velocity.init(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
