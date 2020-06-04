package com.aloneness.well.mybatis.exception;

import com.aloneness.well.framework.enums.ErrorCodeEnum;
import com.aloneness.well.framework.enums.ExStatus;
import com.aloneness.well.framework.exception.IExceptionResolverService;
import com.aloneness.well.framework.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.RecoverableDataAccessException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLFeatureNotSupportedException;

/**
 * 自定义异常处理
 *
 * @author: tong
 * @create: 2020-06-04 22:57
 */
@Slf4j
public class SqlExceptionResolverService implements IExceptionResolverService {

    @Override
    public ExStatus doException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex, Object view) {
        if (ex instanceof DeadlockLoserDataAccessException) {
            log.error(ex.getMessage(), ex);
            ResponseUtil.sendFail(request, response, ErrorCodeEnum.INTERNAL_SERVER_ERROR.convert("当前的操作因为死锁而失败"), ex);
            return ExStatus.HIT;
        }
        if (ex instanceof DataIntegrityViolationException) {
            log.error(ex.getMessage(), ex);
            ResponseUtil.sendFail(request, response, ErrorCodeEnum.INTERNAL_SERVER_ERROR.convert("Insert或Update数据时违反了完整性，例如违反了惟一性限制"), ex);
            return ExStatus.HIT;
        }
        if (ex instanceof RecoverableDataAccessException) {
            log.error(ex.getMessage(), ex);
            ResponseUtil.sendFail(request, response, ErrorCodeEnum.INTERNAL_SERVER_ERROR.convert("获取到数据库无效的连接"), ex);
            return ExStatus.HIT;
        }
        if (ex instanceof SQLFeatureNotSupportedException) {
            log.error(ex.getMessage(), ex);
            ResponseUtil.sendFail(request, response, ErrorCodeEnum.INTERNAL_SERVER_ERROR.convert("数据库操作异常"), ex);
            return ExStatus.HIT;
        }
        if (ex instanceof InvalidDataAccessApiUsageException) {
            log.error(ex.getMessage(), ex);
            ResponseUtil.sendFail(request, response, ErrorCodeEnum.INTERNAL_SERVER_ERROR.convert("数据库操作异常"), ex);
            return ExStatus.HIT;
        }
        return ExStatus.SKIP;
    }
}