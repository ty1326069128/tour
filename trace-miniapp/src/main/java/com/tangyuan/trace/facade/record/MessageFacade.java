package com.tangyuan.trace.facade.record;


import com.tangyuan.trace.entity.InnerMessageEntity;
import com.tangyuan.trace.service.base.Service;

public interface MessageFacade extends Service<InnerMessageEntity> {


    int findCountByOpenId(String openId);
}
