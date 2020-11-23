package com.tangyuan.trace.facade.impl;


import com.tangyuan.trace.entity.InnerMessageEntity;
import com.tangyuan.trace.facade.MessageFacade;
import com.tangyuan.base.service.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@Slf4j
@Service
public class MessageFacadeImpl extends AbstractService<InnerMessageEntity> implements MessageFacade {


    @Override
    public int findCountByOpenId(String openId) {
        Condition condition = new Condition(InnerMessageEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("openId", openId)
                .andEqualTo("status", 0);
        return this.findCountByCondtion(condition);
    }
}
