package com.tangyuan.trace.facade.impl;


import com.tangyuan.common.base.service.AbstractService;
import com.tangyuan.trace.dao.InnerMessageTextDAO;
import com.tangyuan.trace.entity.InnerMessageTextEntity;
import com.tangyuan.trace.facade.InnerMessageTextFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InnerMessageTextFacadeImpl extends AbstractService<InnerMessageTextEntity> implements InnerMessageTextFacade {

    @Resource
    InnerMessageTextDAO messageTextDAO;

    @Override
    public List<InnerMessageTextEntity> messageTextFacade(String openId) {
        return messageTextDAO.messageTextFacade(openId);
    }
}
