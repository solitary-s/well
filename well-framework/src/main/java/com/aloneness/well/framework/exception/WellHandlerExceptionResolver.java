package com.aloneness.well.framework.exception;

import com.aloneness.well.framework.exception.assertException.ApiException;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * well 全局异常处理
 *
 * @author: tong
 * @create: 2020-06-03 22:03
 */
public class WellHandlerExceptionResolver extends AbstractHandlerExceptionResolver {


    private Map<String, IExceptionResolverService> resolverServices;


    public WellHandlerExceptionResolver(Map<String, IExceptionResolverService> resolverServices) {
        setOrder(Ordered.LOWEST_PRECEDENCE);
        this.resolverServices = resolverServices;
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        try {

            if (e instanceof ApiException) {

            }


        } catch (Exception exception) {

        }

        return null;
    }
}
