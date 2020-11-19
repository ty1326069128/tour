package com.tangyuan.trace.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/18 17:04
 */
@Data
public class RecordPoint {

    private BigDecimal lat = BigDecimal.ZERO;
    private BigDecimal lng = BigDecimal.ZERO;
    private String address;
    private String title;
    private String story;
    private SessionInfo sessionInfo;
    private Integer storyId;

    @Data
    public static class SessionInfo {
        private String openId;
        private String token;
    }
}
