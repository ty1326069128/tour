package com.tangyuan.trace.facade.impl;

import com.tangyuan.common.base.service.AbstractService;
import com.tangyuan.trace.entity.StoryUserEntity;
import com.tangyuan.trace.facade.StoryUserFacade;
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
