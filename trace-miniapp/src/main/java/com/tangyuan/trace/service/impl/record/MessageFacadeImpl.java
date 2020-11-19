package com.tangyuan.trace.service.impl.record;


import com.tangyuan.trace.entity.InnerMessageEntity;
import com.tangyuan.trace.facade.record.MessageFacade;
import com.tangyuan.trace.service.base.AbstractService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

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
