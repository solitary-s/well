package com.aloneness.well.framework.wrapper;

import com.aloneness.well.framework.exception.assertException.ErrorCode;
import com.aloneness.well.framework.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MimeTypeUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * response 包装类
 *
 * @author liaoshitong
 * @date 2020/6/4
 */
@Slf4j
public class ResponseWrapper extends HttpServletResponseWrapper {

    private ErrorCode errorCode;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public ResponseWrapper(HttpServletResponse response, ErrorCode errorCode) {
        super(response);
        setErrorCode(errorCode);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
        super.setStatus(errorCode.getCode());
    }



    /**
     * response 输出对象
     *
     * @param object
     */
    public void writeValueAsJson(Object object) {
        if (super.isCommitted()) {
            log.warn("response is committed");
            return;
        }
        super.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
        super.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter writer = super.getWriter()) {
            writer.print(JacksonUtil.toJson(object));
            writer.flush();
        } catch (IOException e) {
            log.warn("response printJson failed");
        }
    }
}
