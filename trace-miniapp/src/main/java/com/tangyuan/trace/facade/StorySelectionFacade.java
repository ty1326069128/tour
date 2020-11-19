package com.tangyuan.trace.facade;


import com.tangyuan.trace.entity.StoryHomeEntity;
import com.tangyuan.base.service.Service;

import java.util.List;

/**
 * Author tangyuan
 * Date  2020-09-24
 */
public interface StorySelectionFacade extends Service<StoryHomeEntity> {

    List<StoryHomeEntity> findByStatus(int status);
}
