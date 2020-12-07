package com.tangyuan.trace.dao;

import com.tangyuan.common.base.dal.CrudDAO;
import com.tangyuan.trace.entity.InnerMessageEntity;
import org.apache.ibatis.annotations.Mapper;


/**
* Author tangyuan
* Date  2020-09-24
*/
@Mapper
public interface InnerMessageDAO extends CrudDAO<InnerMessageEntity> {

}