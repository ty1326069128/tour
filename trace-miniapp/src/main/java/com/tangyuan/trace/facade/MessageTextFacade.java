package com.tangyuan.trace.facade;



import com.tangyuan.trace.entity.InnerMessageTextEntity;
import com.tangyuan.base.service.Service;

import java.util.List;

public interface MessageTextFacade extends Service<InnerMessageTextEntity> {


    List<InnerMessageTextEntity> messageTextFacade(String openId);
}
