package com.aloneness.well.framework.exception.assertException;

import com.aloneness.well.framework.enums.ErrorCodeEnum;

/**
 * 业务类异常
 *
 * @author: tong
 * @create: 2020-06-03 23:11
 */
public class ApiException extends RuntimeException {

    private ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public ApiException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.msg());
        this.errorCode = errorCodeEnum.convert();
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
