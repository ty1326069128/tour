package com.tangyuan.trace.service.base;

import com.github.pagehelper.Page;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 *
 * @author tangyuan
 */
public interface Service<T> {
    /*
    int rtn = mscSendTaskDAO.insert(MscSendTaskEntity t);
    int rtn = mscSendTaskDAO.insertList(List < MscSendTaskEntity > list);
    int rtn = mscSendTaskDAO.insertSelective(MscSendTaskEntity t);
    int rtn = mscSendTaskDAO.insertUseGeneratedKeys(MscSendTaskEntity t);
    List<T> list = mscSendTaskDAO.select(MscSendTaskEntity t);
    List<T> list = mscSendTaskDAO.selectAll();
    List<T> list = mscSendTaskDAO.selectByIds(String s);
    List<T> list = mscSendTaskDAO.selectByCondition(Object o);
    List<T> list = mscSendTaskDAO.selectByExample(Object o);
    MscSendTaskEntity t = mscSendTaskDAO.selectByPrimaryKey(Object o);
    int count = mscSendTaskDAO.selectCount(MscSendTaskEntity t);
    int count = mscSendTaskDAO.selectCountByCondition(Object o);
    MscSendTaskEntity t = mscSendTaskDAO.selectOne(MscSendTaskEntity t);
    int rtn = mscSendTaskDAO.updateByCondition(MscSendTaskEntity t,Object o);
    int rtn = mscSendTaskDAO.updateByConditionSelective(MscSendTaskEntity t,Object o);
    int rtn = mscSendTaskDAO.updateByExampleSelective(MscSendTaskEntity t,Object o);
    int rtn = mscSendTaskDAO.updateByPrimaryKey(MscSendTaskEntity t);
    int rtn = mscSendTaskDAO.updateByPrimaryKeySelective(MscSendTaskEntity t);
    int rtn = mscSendTaskDAO.deleteByIds(String s);
    int rtn = mscSendTaskDAO.delete(MscSendTaskEntity t);
    int rtn = mscSendTaskDAO.deleteByCondition(Object o);
    int rtn = mscSendTaskDAO.deleteByPrimaryKey(Object o);
    */


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
    Page<Object> findPageByCondition(Condition condition, Integer... page);
}
