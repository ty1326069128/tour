package com.tangyuan.common.base.dal;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.delete.DeleteByPrimaryKeyMapper;
import tk.mybatis.mapper.common.base.delete.DeleteMapper;
import tk.mybatis.mapper.common.condition.DeleteByConditionMapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

public interface DeleteDAO<T> extends Marker,
        DeleteMapper<T>,
        DeleteByPrimaryKeyMapper<T>,
        DeleteByConditionMapper<T>,
        DeleteByIdsMapper<T> {
}
