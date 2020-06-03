package com.aloneness.well.framework.exception;

import com.aloneness.well.framework.enums.ExStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 默认的自定义异常处理
 *
 * @author: tong
 * @create: 2020-06-03 22:15
 */
public class DefaultExceptionResolverService implements IExceptionResolverService{

    @Override
    public ExStatus doException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex, Object view) {
        return ExStatus.SKIP;
    }
}
