package com.aloneness.well.framework.exception;

import com.aloneness.well.framework.enums.ExStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理扩展
 *
 * @author: tong
 * @create: 2020-06-03 22:11
 */
public interface IExceptionResolverService {

    public ExStatus doException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex, Object view);

}
