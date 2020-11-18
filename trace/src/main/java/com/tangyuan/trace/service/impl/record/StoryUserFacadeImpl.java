package com.tangyuan.trace.service.impl.record;

import com.tangyuan.trace.dal.entity.StoryUserEntity;
import com.tangyuan.trace.facade.record.StoryUserFacade;
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
public class StoryUserFacadeImpl extends AbstractService<StoryUserEntity> implements StoryUserFacade {

    @Override
    public List<StoryUserEntity> findUserByOpenId(String openId) {
        Condition condition = new Condition(StoryUserEntity.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("openId", openId);
        return this.findByCondition(condition);
    }
}