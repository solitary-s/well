package com.aloneness.well.framework.response;

import cn.hutool.http.HttpStatus;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import cn.hutool.core.util.ObjectUtil;

import java.lang.annotation.Annotation;

/**
 * 开启统一数据返回结构包装
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ApiControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        Controller controller = methodParameter.getDeclaringClass().getAnnotation(Controller.class);
        RestController restController = methodParameter.getDeclaringClass().getAnnotation(RestController.class);
        ResponseBody responseBody = methodParameter.getMethodAnnotation(ResponseBody.class);
        NotWrap notWrap = methodParameter.getMethodAnnotation(NotWrap.class);

        // 是否包裹
        boolean wrap = true;
        if (ObjectUtil.isNotNull(notWrap)) {
            wrap = notWrap.wrap();
        }
        return (ObjectUtil.isNotNull(restController) || (ObjectUtil.isNotNull(controller) && ObjectUtil.isNotNull(responseBody))) && wrap;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        NotWrap notWrap = methodParameter.getExecutable().getDeclaringClass().getAnnotation(NotWrap.class);
        if (ObjectUtil.isNull(notWrap)) {
            notWrap = methodParameter.getMethodAnnotation(NotWrap.class);
        }

        // 如果 notWrap不为空，并且warp为false 则不包裹
        if (ObjectUtil.isNotNull(notWrap) && !notWrap.wrap()) {
            return o;
        }

        return o instanceof ResponseInfo ? o : ResponseInfo.success(response, HttpStatus.HTTP_OK, o);
    }
}
