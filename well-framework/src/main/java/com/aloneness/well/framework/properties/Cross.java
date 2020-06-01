package com.aloneness.well.framework.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 跨域配置
 *
 * @author: tong
 * @create: 2020-06-01 22:24
 */
@Setter
@Getter
public class Cross {

    // Cross开关
    private boolean enabled = true;

    // 允许的域名白名单，可以*
    private String accessControlAllowOrigin = "*";

    // 是否允许携带cookie
    private String accessControlAllowCredentials = "true";

    // 允许哪些类型请求，可以*
    private String accessControlAllowMethods = "POST, GET, OPTIONS, DELETE, PUT, HEAD";

    // 自定义请求头
    private String accessControlAllowHeaders = "User-Agent, Origin, Cache-Control, Content-type, Accept, X-Requested-With, withCredentials, AccessToken, Authorization, x-token, sso_sessionid, sso-sessionid";

    // 用来指定本次预检请求的有效期，单位为秒
    private String accessControlMaxAge = "3600";

    // 拦截路径
    private String pathPatterns = "/**";
}
