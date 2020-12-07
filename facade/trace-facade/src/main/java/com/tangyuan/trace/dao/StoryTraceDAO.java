package com.tangyuan.trace.dao;


import com.tangyuan.common.base.dal.CrudDAO;
import com.tangyuan.trace.entity.StoryTraceEntity;
import org.apache.ibatis.annotations.Mapper;


/**
* Author tangyuan
* Date  2020-09-24
*/
@Mapper
public interface StoryTraceDAO extends CrudDAO<StoryTraceEntity> {

}