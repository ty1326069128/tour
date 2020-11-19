package com.tangyuan.trace.service.base;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tangyuan.annotations.ServiceLog;
import com.tangyuan.dal.base.CrudDAO;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 *
 * @author tangyuan
 */
public abstract class AbstractService<T> implements Service<T> {

    @Autowired
    protected CrudDAO<T> dao;

    /**
     * 当前泛型真实类型的Class
     */
    private Class<T> modelClass;

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    @ServiceLog(description = "保存/新增记录")
    public int save(T entity) {
        return dao.insertSelective(entity);
    }


    @Override
    @ServiceLog(description = "通过ID查找记录")
    public T findById(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    @ServiceLog(description = "通过实体值查找记录")
    public List<T> findByEntity(T entity) {
        return dao.select(entity);
    }

    @Override
    @ServiceLog(description = "根据条件查找记录")
    public List<T> findByCondition(Condition condition) {
        return dao.selectByCondition(condition);
    }

    @Override
    @ServiceLog(description = "获取所有记录")
    public List<T> findAll() {
        return dao.selectAll();
    }

    @Override
    @ServiceLog(description = "根据实体值获取记录数量")
    public int findCountByEntity(T entity) {
        return dao.selectCount(entity);
    }

    @Override
    @ServiceLog(description = "根据条件获取记录数量")
    public int findCountByCondtion(Condition condition) {
        return dao.selectCountByCondition(condition);
    }


    @Override
    @ServiceLog(description = "通过ID主鍵刪除记录")
    public int deleteById(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }


    @Override
    @ServiceLog(description = "更新记录")
    public int update(T entity) {
        return dao.updateByPrimaryKeySelective(entity);
    }

    @Override
    @ServiceLog(description = "根据条件更新记录")
    public int updateByCondition(T entity, Condition condition) {
        return dao.updateByCondition(entity, condition);
    }

    @Override
    @ServiceLog(description = "分页查询")
    public Page<Object> findPageByCondition(Condition condition, Integer ... page) {
        //使用分页插件,核心代码就这一行，页数、每页行数
        Page<Object> objects=null;
       if (page != null && page.length >0 && page.length>=2) {
               objects = PageHelper.startPage(page[0], page[1]);
       }else{
           objects= PageHelper.startPage(1,20);
       }
        //在 mapper.xml 中不要加 limit 分页，插件会自动拦截和添加 limit 分页
        dao.selectByCondition(condition);
        return objects;
    }

}
