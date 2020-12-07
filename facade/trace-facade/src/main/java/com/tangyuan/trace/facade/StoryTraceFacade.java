package com.tangyuan.trace.facade;


import com.github.pagehelper.Page;
import com.tangyuan.common.base.service.Service;
import com.tangyuan.trace.entity.StoryTraceEntity;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Author tangyuan
 * Date  2020-09-24
 */
public interface StoryTraceFacade extends Service<StoryTraceEntity> {

    int findStoryCountByUserId(Integer userId);

    List<StoryTraceEntity> findStoryByUserId(Integer userId);

    Page<StoryTraceEntity> findByStatus(Condition condition, Integer... page);
}
