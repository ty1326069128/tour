package com.tangyuan.trace.facade.record;

import com.tangyuan.trace.dal.entity.StoryHomeEntity;
import com.tangyuan.trace.service.base.Service;

import java.util.List;

/**
 * Author tangyuan
 * Date  2020-09-24
 */
public interface StorySelectionFacade extends Service<StoryHomeEntity> {

    List<StoryHomeEntity> findByStatus(int status);
}
