package com.tangyuan.trace.dao;

import com.tangyuan.base.dal.CrudDAO;
import com.tangyuan.trace.entity.StoryUserEntity;
import org.apache.ibatis.annotations.Mapper;


/**
* Author tangyuan
* Date  2020-09-24
*/
@Mapper
public interface WxStoryUserDAO extends CrudDAO<StoryUserEntity> {

}