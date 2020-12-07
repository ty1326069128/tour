package com.tangyuan.miniapp.service;

import com.tangyuan.trace.dto.MiniAppPhone;
import com.tangyuan.common.result.CommonDTO;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/8 20:27
 */
public interface WebWeChatInfoService {

    CommonDTO wxLogin(MiniAppPhone miniAppPhone);


}
