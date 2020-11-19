package com.tangyuan.trace.service.impl;

import com.tangyuan.base.service.AbstractService;
import com.tangyuan.trace.dao.TyInnerMessageDAO;
import com.tangyuan.trace.entity.TyInnerMessageEntity;
import com.tangyuan.trace.facade.TyInnerMessageFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
* Author tangyuan
* Date  2020-11-19
*/
@Service
public class TyInnerMessageFacadeImpl extends AbstractService<TyInnerMessageEntity> implements TyInnerMessageFacade {
    @Resource
    private TyInnerMessageDAO tyInnerMessageDAO;
}
