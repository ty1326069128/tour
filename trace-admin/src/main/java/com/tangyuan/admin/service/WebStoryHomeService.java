package com.tangyuan.admin.service;

import com.tangyuan.result.CommonDTO;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/20 11:23
 */
public interface WebStoryHomeService {
    CommonDTO getStoryHomeList(Integer status);
}
