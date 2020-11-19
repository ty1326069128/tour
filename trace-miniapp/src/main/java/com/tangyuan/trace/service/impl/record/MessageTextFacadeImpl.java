package com.tangyuan.trace.service.impl.record;


import com.tangyuan.trace.dao.MessageTextDAO;
import com.tangyuan.trace.entity.InnerMessageTextEntity;
import com.tangyuan.trace.facade.record.MessageTextFacade;
import com.tangyuan.trace.service.base.AbstractService;
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
