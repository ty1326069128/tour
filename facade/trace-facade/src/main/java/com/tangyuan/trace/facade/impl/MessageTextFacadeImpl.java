package com.tangyuan.trace.facade.impl;


import com.tangyuan.trace.dao.MessageTextDAO;
import com.tangyuan.trace.entity.InnerMessageTextEntity;
import com.tangyuan.trace.facade.MessageTextFacade;
import com.tangyuan.base.service.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageTextFacadeImpl extends AbstractService<InnerMessageTextEntity> implements MessageTextFacade {

    @Resource
    MessageTextDAO messageTextDAO;

    @Override
    public List<InnerMessageTextEntity> messageTextFacade(String openId) {
        return messageTextDAO.messageTextFacade(openId);
    }
}
