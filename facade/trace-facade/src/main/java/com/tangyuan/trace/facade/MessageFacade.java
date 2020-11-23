package com.tangyuan.trace.facade;


import com.tangyuan.trace.entity.InnerMessageEntity;
import com.tangyuan.base.service.Service;

public interface MessageFacade extends Service<InnerMessageEntity> {


    int findCountByOpenId(String openId);
}
