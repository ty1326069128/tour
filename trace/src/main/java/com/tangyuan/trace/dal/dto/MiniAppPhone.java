package com.tangyuan.trace.dal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/9 16:23
 */
@Data
@NoArgsConstructor
public class MiniAppPhone {
    String appId;
    String code;
    String sessionKey;
    String signature;
    String rawData;
    String encryoteData;
    String iv;
}
