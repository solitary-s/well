package com.aloneness.well.framework.exception.assertException;

import cn.hutool.core.util.ObjectUtil;
import com.aloneness.well.framework.enums.ErrorCodeEnum;

/**
 * 断言-抛出异常
 *
 * @author: tong
 * @create: 2020-06-03 22:56
 */
public class ApiAssert {

    public static void failure(ErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

    /**
     * 断言 为null
     *
     * @param errorCode
     * @param conditions
     */
    public static void isNull(ErrorCode errorCode, Object conditions) {
        if (ObjectUtil.isNotNull(conditions)) {
            failure(errorCode);
        }
    }

    /**
     * 断言 不为null
     *
     * @param errorCode
     * @param conditions
     */
    public static void isNotNull(ErrorCode errorCode, Object conditions) {
        if (ObjectUtil.isNull(conditions)) {
            failure(errorCode);
        }
    }

}
