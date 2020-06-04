package com.aloneness.well.framework.util;

import cn.hutool.core.util.ObjectUtil;
import com.aloneness.well.framework.exception.assertException.ErrorCode;
import com.aloneness.well.framework.response.ResponseInfo;
import com.aloneness.well.framework.wrapper.ResponseWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * response 工具类
 *
 * @author: tong
 * @create: 2020-06-03 23:26
 */
public class ResponseUtil {

    /**
     * 获取response包装类
     *
     * @param response
     * @param errorCode
     * @return
     */
    public static ResponseWrapper getWrapper(HttpServletResponse response, ErrorCode errorCode) {
        return new ResponseWrapper(response, errorCode);
    }

    public static void writeValAsJson(HttpServletRequest request, ResponseWrapper response, Object object) {
        if (ObjectUtil.isNotNull(response) && ObjectUtil.isNotNull(object)) {
            response.writeValueAsJson(object);
        }
    }

    public static void sendFail(HttpServletRequest request, HttpServletResponse response, ErrorCode errorCode) {
        writeValAsJson(request, getWrapper(response, errorCode), ResponseInfo.fail(errorCode));
    }

    public static void sendFail(HttpServletRequest request, HttpServletResponse response, ErrorCode errorCode, Exception ex) {
        writeValAsJson(request, getWrapper(response, errorCode), ResponseInfo.fail(errorCode,ex));
    }
}
