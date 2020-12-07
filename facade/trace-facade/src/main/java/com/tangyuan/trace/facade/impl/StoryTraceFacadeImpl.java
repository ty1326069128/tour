package com.tangyuan.trace.facade.impl;

import com.github.pagehelper.Page;
import com.tangyuan.common.base.service.AbstractService;
import com.tangyuan.trace.entity.StoryTraceEntity;
import com.tangyuan.trace.facade.StoryTraceFacade;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * Author tangyuan
 * Date  2020-09-24
 */
@Service
public class StoryTraceFacadeImpl extends AbstractService<StoryTraceEntity> implements StoryTraceFacade {

    @Override
    public int findStoryCountByUserId(Integer userId) {
        Condition condition = new Condition(StoryTraceEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userId", userId);
        return this.findCountByCondtion(condition);
    }

    @Override
    public List<StoryTraceEntity> findStoryByUserId(Integer userId) {
        Condition condition = new Condition(StoryTraceEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("userId", userId);
        return this.findByCondition(condition);
    }

    @Override
    public Page<StoryTraceEntity> findByStatus(Condition condition, Integer... page) {
        return this.findPageByCondition(condition, page);
    }
}
