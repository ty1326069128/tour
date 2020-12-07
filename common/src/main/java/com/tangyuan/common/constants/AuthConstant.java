package com.tangyuan.common.constants;

/**
 * 权限相关常量定义
 */
public interface AuthConstant {

    /**
     * JWT存储权限前缀
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    String AUTHORITY_CLAIM_NAME = "authorities";

    /**
     * 后台管理client_id
     */
    String DEALERS_CLIENT_ID = "web-dealers";

    /**
     * 前台商城client_id
     */
    String WEIXIN_CLIENT_ID = "web-weixin";

    /**
     * 后台管理接口路径匹配
     */
    String ADMIN_URL_PATTERN = "/service-admin/**";

    /**
     * Redis缓存权限规则key
     */
    String RESOURCE_ROLES_MAP_KEY = "auth:resourceRolesMap";

    /**
     * 认证信息Http请求头
     */
    String JWT_TOKEN_HEADER = "Authorization";

    /**
     * JWT令牌前缀
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * 用户信息Http请求头
     */
    String USER_TOKEN_HEADER = "user";

    /**
     * 密钥
     */
    String SECRET = "ty_trace_qwer";

    /**
     * 用户名称 jwt username
     * JWT {@code Subject} claims parameter name: <code>"sub"</code>
     */
    String USERNAME = "sub";

    String USER_ID = "id";

    String OPEN_ID = "open_id";
    /**
     * 创建时间
     */
    String CREATED = "created";

    /**
     * 有效期24小时
     */
    long EXPIRE_TIME = 365 * 24 * 60 * 60 * 1000;

}
