package com.aloneness.well.framework.test.service;

import com.aloneness.well.framework.enums.ErrorCodeEnum;
import com.aloneness.well.framework.exception.assertException.ApiAssert;
import org.springframework.stereotype.Service;

/**
 * @author liaoshitong
 * @date 2020/6/4
 */
@Service
public class UserService {

    public void user() {
        String str = null;
        ApiAssert.isNotNull(ErrorCodeEnum.BAD_REQUEST.convert("str 为 null"), str);
    }
}
