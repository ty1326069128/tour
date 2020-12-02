package com.tangyuan.trace.facade.impl;

import com.tangyuan.base.service.AbstractService;
import com.tangyuan.trace.entity.StoryHomeEntity;
import com.tangyuan.trace.facade.StoryHomeFacade;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * Author tangyuan
 * Date  2020-09-24
 */
@Service
public class StoryHomeFacadeImpl extends AbstractService<StoryHomeEntity> implements StoryHomeFacade {

    @Override
    public List<StoryHomeEntity> findByStatus(int status) {
        Condition condition = new Condition(StoryHomeEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("status", status);
        condition.orderBy("sort").desc();
        return this.findByCondition(condition);
    }
}
