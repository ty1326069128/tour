package com.tangyuan.trace.facade;


import com.tangyuan.trace.entity.StoryUserEntity;
import com.tangyuan.base.service.Service;

import java.util.List;

/**
* Author tangyuan
* Date  2020-09-24
*/
public interface StoryUserFacade extends Service<StoryUserEntity> {


    List<StoryUserEntity> findUserByOpenId(String openId);
}
