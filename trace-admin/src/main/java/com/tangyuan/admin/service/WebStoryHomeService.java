package com.tangyuan.admin.service;

import com.tangyuan.common.result.BaseQueryDTO;
import com.tangyuan.common.result.CommonDTO;
import com.tangyuan.trace.dto.ReqStoryHomeQueryDTO;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/20 11:23
 */
public interface WebStoryHomeService {
    CommonDTO getStoryHomeList(BaseQueryDTO<ReqStoryHomeQueryDTO> baseQueryDTO);
}
