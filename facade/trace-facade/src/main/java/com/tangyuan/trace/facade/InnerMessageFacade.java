package com.tangyuan.trace.facade;


import com.tangyuan.base.service.Service;
import com.tangyuan.trace.entity.InnerMessageEntity;

public interface InnerMessageFacade extends Service<InnerMessageEntity> {


    int findCountByOpenId(String openId);
}
