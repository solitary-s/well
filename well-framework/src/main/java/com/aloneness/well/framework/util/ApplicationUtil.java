package com.aloneness.well.framework.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring application 上下文
 *
 * @author: tong
 * @create: 2020-06-01 22:43
 */
public class ApplicationUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationUtil.applicationContext = applicationContext;
    }
}
