package com.tangyuan.trace.facade.record;


import com.tangyuan.trace.entity.StoryTraceEntity;
import com.tangyuan.trace.service.base.Service;

import java.util.List;

/**
* Author tangyuan
* Date  2020-09-24
*/
public interface StoryTraceFacade extends Service<StoryTraceEntity> {

    int findStoryCountByUserId(Integer userId);

    List<StoryTraceEntity> findStoryByUserId(Integer userId);
}
