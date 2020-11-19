package com.tangyuan.trace.dto;

import lombok.Data;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/24 18:47
 */
@Data
public class UserInfo {
    private SessionInfo sessionInfo;
    private String name;
    private String avatar;

    @Data
    public static class SessionInfo {
        private String token;
        private String openId;
    }
}

