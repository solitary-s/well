package com.aloneness.well.framework.response;

import cn.hutool.http.HttpStatus;
import com.aloneness.well.framework.exception.assertException.ErrorCode;
import lombok.*;
import org.springframework.http.server.ServerHttpResponse;

import java.io.Serializable;


/**
 * 接口返回数据
 *
 * @author aloneness
 */
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInfo<T> implements Serializable {

    private static final long serialVersionUID = -1296644476749112463L;

    private int code;

    private T data;

    private String msg;

    public static <T> ResponseInfo<T> success(T data) {
        ResponseInfo<T> responseInfo = new ResponseInfo<>();
        responseInfo.setCode(HttpStatus.HTTP_OK);
        responseInfo.setData(data);
        return responseInfo;
    }

    public static <T> ResponseInfo<T> success(ServerHttpResponse response, int code, T data) {
        response.setStatusCode(org.springframework.http.HttpStatus.valueOf(code));
        return ResponseInfo.<T>builder().code(code).data(data).build();
    }

    public static ResponseInfo fail(ErrorCode errorCode, Exception e) {
        return ResponseInfo.builder().code(errorCode.getCode()).msg(errorCode.getMsg() + e.getMessage()).build();
    }

    public static ResponseInfo fail(ErrorCode errorCode) {
        return ResponseInfo.builder().code(errorCode.getCode()).msg(errorCode.getMsg()).build();
    }
}
