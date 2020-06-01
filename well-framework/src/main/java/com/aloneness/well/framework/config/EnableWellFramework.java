package com.aloneness.well.framework.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 开启well framework框架
 *
 * @author aloneness
 */
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Target(value = { java.lang.annotation.ElementType.TYPE })
@Documented
@Import(value = { WellFrameworkConfig.class, WellBeanConfig.class})
public @interface EnableWellFramework {

}
