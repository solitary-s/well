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

    public static void failure(ErrorCodeEnum errorCodeEnum) {
        throw new ApiException(errorCodeEnum);
    }

    /**
     * 断言 为null
     *
     * @param errorCodeEnum
     * @param conditions
     */
    public static void isNull(ErrorCodeEnum errorCodeEnum, Object... conditions) {
        if (ObjectUtil.isNotNull(conditions)) {
            failure(errorCodeEnum);
        }
    }

    /**
     * 断言 不为null
     *
     * @param errorCodeEnum
     * @param conditions
     */
    public static void isNotNull(ErrorCodeEnum errorCodeEnum, Object... conditions) {
        if (ObjectUtil.isNull(conditions)) {
            failure(errorCodeEnum);
        }
    }

}
