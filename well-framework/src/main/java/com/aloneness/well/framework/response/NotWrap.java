package com.aloneness.well.framework.response;


import java.lang.annotation.*;

/**
 * controller 返回数据不包装
 *
 * @author aloneness
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotWrap {

    /**
     * 是否包装
     *
     * @return
     */
    boolean wrap() default false;

}
