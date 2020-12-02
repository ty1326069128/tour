package com.tangyuan.miniapp.service;

import com.tangyuan.result.CommonDTO;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/18 19:34
 */
public interface WxUserCenterService {
    CommonDTO getInnerMessage(String openId);

    CommonDTO lookMessage(String openId);
}
