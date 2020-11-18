package com.tangyuan.trace.facade.record;

import com.tangyuan.trace.dal.entity.StoryUserEntity;
import com.tangyuan.trace.service.base.Service;

import java.util.List;

/**
* Author tangyuan
* Date  2020-09-24
*/
public interface StoryUserFacade extends Service<StoryUserEntity> {


    List<StoryUserEntity> findUserByOpenId(String openId);
}
