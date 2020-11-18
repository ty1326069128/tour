package com.tangyuan.trace.dal.dao;

import com.tangyuan.trace.dal.base.CrudDAO;
import com.tangyuan.trace.dal.entity.StoryTraceEntity;
import org.apache.ibatis.annotations.Mapper;


/**
* Author tangyuan
* Date  2020-09-24
*/
@Mapper
public interface StoryUserDAO extends CrudDAO<StoryTraceEntity> {

}