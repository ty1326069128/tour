package com.tangyuan.base.service;

import com.github.pagehelper.Page;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 *
 * @author tangyuan
 */
public interface Service<T> {

    //保存/新增记录
    int save(T entity);

    // 根据主键ID查询记录
    T findById(Integer id);

    // 获取所有记录
    List<T> findAll();

    // 根据条件获取记录
    List<T> findByCondition(Condition condition);

    // 根据实体值获取记录
    List<T> findByEntity(T entity);

    // 根据实体值获取记录总数
    int findCountByEntity(T entity);

    // 根据条件获取记录总数
    int findCountByCondtion(Condition condition);

    // 根据ID更新记录
    int update(T model);

    // 根据实体值和条件更新记录
    int updateByCondition(T entity, Condition condition);

    //根据Id删除记录
    int deleteById(Integer id);

    // 分页
    //  List<T>  findPageByCondition(Condition condition, Integer page,  Integer rows);
    Page<T> findPageByCondition(Condition condition, Integer... page);
}
