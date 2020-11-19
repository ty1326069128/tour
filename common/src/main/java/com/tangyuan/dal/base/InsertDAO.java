package com.tangyuan.dal.base;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.MySqlMapper;
import tk.mybatis.mapper.common.base.insert.InsertMapper;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 基础插入功能mapper
 *
 * @author tangyuan
 * Date: 2019年7月1日
 * Time: 12:44
 */
public interface InsertDAO<T> extends Marker,
        InsertMapper<T>,
    InsertSelectiveMapper<T>,
    MySqlMapper<T> {
}
