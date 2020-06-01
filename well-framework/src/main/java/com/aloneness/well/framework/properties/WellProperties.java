package com.aloneness.well.framework.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Well 项目配置
 *
 * @author: tong
 * @create: 2020-06-01 22:20
 */
@Setter
@Getter
@ConfigurationProperties(prefix = WellProperties.PREFIX)
public class WellProperties {

    public static final String PREFIX = "well";

    /**
     * @NestedConfigurationProperty 当一个类中引用了外部类，需要在该属性上加该注解
     */
    @NestedConfigurationProperty
    private Cross cross = new Cross();
}
