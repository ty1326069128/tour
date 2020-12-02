package com.tangyuan.trace.facade;


import com.tangyuan.base.service.Service;
import com.tangyuan.trace.entity.InnerMessageTextEntity;

import java.util.List;

public interface InnerMessageTextFacade extends Service<InnerMessageTextEntity> {


    List<InnerMessageTextEntity> messageTextFacade(String openId);
}
