package com.aloneness.well.framework.test.exception;

import com.aloneness.well.framework.enums.ErrorCodeEnum;
import com.aloneness.well.framework.enums.ExStatus;
import com.aloneness.well.framework.exception.IExceptionResolverService;
import com.aloneness.well.framework.util.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liaoshitong
 * @date 2020/6/4
 */
public class TestException implements IExceptionResolverService {

    @Override
    public ExStatus doException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex, Object view) {
        if (ex instanceof CustomException) {
            ResponseUtil.sendFail(request, response, ErrorCodeEnum.BAD_REQUEST.convert("test exception error"));
        }
        return ExStatus.HIT;
    }
}
