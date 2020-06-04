package com.aloneness.well.framework.exception;

import cn.hutool.core.util.ObjectUtil;
import com.aloneness.well.framework.enums.ErrorCodeEnum;
import com.aloneness.well.framework.enums.ExStatus;
import com.aloneness.well.framework.exception.assertException.ApiException;
import com.aloneness.well.framework.util.ResponseUtil;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

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
                handleApiException(httpServletRequest, httpServletResponse, (ApiException) e);
            } else {
                // 其他异常
                ExStatus doException = ExStatus.HIT;
                if (ObjectUtil.isNotEmpty(resolverServices)) {
                    Set<Map.Entry<String, IExceptionResolverService>> entrySet = resolverServices.entrySet();
                    for (Map.Entry<String, IExceptionResolverService> entry : entrySet) {
                        IExceptionResolverService resolverService = entry.getValue();
                        ModelAndView modelAndView = null;
                        doException = resolverService.doException(httpServletRequest, httpServletResponse, o, e, modelAndView);
                        if (doException == ExStatus.HIT) {
                            break;
                        } else if (doException == ExStatus.RETURN) {
                            return modelAndView;
                        }
                    }
                }
                if (doException == ExStatus.SKIP) {
                    handleException(e, httpServletRequest, httpServletResponse);
                }
            }
        } catch (Exception exception) {
            logger.warn(exception);
        }
        return new ModelAndView();
    }

    /**
     * 处理断言异常
     *
     * @param request
     * @param response
     * @param e
     */
    protected void handleApiException(HttpServletRequest request, HttpServletResponse response, ApiException e) {
        ResponseUtil.sendFail(request, response, e.getErrorCode());
    }

    protected void handleException(Exception e, HttpServletRequest request, HttpServletResponse response) {
        ResponseUtil.sendFail(request, response, ErrorCodeEnum.INTERNAL_SERVER_ERROR.convert(), e);
    }
}
