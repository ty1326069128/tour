package com.tangyuan.trace.facade;


import com.tangyuan.base.service.Service;
import com.tangyuan.trace.entity.StoryTraceEntity;

import java.util.List;

/**
 * Author tangyuan
 * Date  2020-09-24
 */
public interface StoryTraceFacade extends Service<StoryTraceEntity> {

    int findStoryCountByUserId(Integer userId);

    List<StoryTraceEntity> findStoryByUserId(Integer userId);

    List<StoryTraceEntity> findByStatus(Integer status, Integer reviewStatus);
}
