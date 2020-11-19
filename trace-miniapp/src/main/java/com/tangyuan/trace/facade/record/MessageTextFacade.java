package com.tangyuan.trace.facade.record;



import com.tangyuan.trace.entity.InnerMessageTextEntity;
import com.tangyuan.trace.service.base.Service;

import java.util.List;

public interface MessageTextFacade extends Service<InnerMessageTextEntity> {


    List<InnerMessageTextEntity> messageTextFacade(String openId);
}
