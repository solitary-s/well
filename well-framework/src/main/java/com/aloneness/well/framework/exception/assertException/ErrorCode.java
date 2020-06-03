package com.aloneness.well.framework.exception.assertException;

import lombok.*;

/**
 * 异常信息
 *
 * @author: tong
 * @create: 2020-06-03 22:44
 */
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
public class ErrorCode {

    @Builder.Default
    private int code = 200;

    private String msg;
}
