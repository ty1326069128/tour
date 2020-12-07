package com.tangyuan.trace.facade;


import com.tangyuan.common.base.service.Service;
import com.tangyuan.trace.entity.StoryHomeEntity;

import java.util.List;

/**
 * Author tangyuan
 * Date  2020-09-24
 */
public interface StoryHomeFacade extends Service<StoryHomeEntity> {

    List<StoryHomeEntity> findByStatus(int status);
}
