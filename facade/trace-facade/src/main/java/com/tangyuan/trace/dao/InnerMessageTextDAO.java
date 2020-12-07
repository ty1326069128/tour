package com.tangyuan.trace.dao;

import com.tangyuan.common.base.dal.CrudDAO;
import com.tangyuan.trace.entity.InnerMessageTextEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;


/**
 * Author tangyuan
 * Date  2020-09-24
 */
@Mapper
public interface InnerMessageTextDAO extends CrudDAO<InnerMessageTextEntity> {

    @Select("SELECT *FROM inner_message_text WHERE id in (SELECT message_id FROM inner_message WHERE open_id = #{openId}) order by post_date desc")
    List<InnerMessageTextEntity> messageTextFacade(@Value("openId") String openId);
}