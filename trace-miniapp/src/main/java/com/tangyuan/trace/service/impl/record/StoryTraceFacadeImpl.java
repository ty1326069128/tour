package com.tangyuan.trace.service.impl.record;

import com.tangyuan.trace.dao.StoryUserDAO;
import com.tangyuan.trace.entity.StoryTraceEntity;
import com.tangyuan.trace.facade.record.StoryTraceFacade;
import com.tangyuan.trace.service.base.AbstractService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;


/**
 * Author tangyuan
 * Date  2020-09-24
 */
@Service
public class StoryTraceFacadeImpl extends AbstractService<StoryTraceEntity> implements StoryTraceFacade {
    @Resource
    private StoryUserDAO storyDAO;

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
}
