package com.tangyuan.trace.service.impl.record;

import com.tangyuan.trace.dal.entity.StoryHomeEntity;
import com.tangyuan.trace.facade.record.StorySelectionFacade;
import com.tangyuan.trace.service.base.AbstractService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * Author tangyuan
 * Date  2020-09-24
 */
@Service
public class StorySelectionFacadeImpl extends AbstractService<StoryHomeEntity> implements StorySelectionFacade {

    @Override
    public List<StoryHomeEntity> findByStatus(int status) {
        Condition condition = new Condition(StoryHomeEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("status", status);
        condition.orderBy("sort").desc();
        return this.findByCondition(condition);
    }
}
