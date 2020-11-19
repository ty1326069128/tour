package com.tangyuan.base.dal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  基础增删改查功能mapper
 * @author tangyuan
 * Date: 2019年7月2日09:15:10
 */
public interface CrudDAO<T> extends
        InsertDAO<T>,
        DeleteDAO<T>,
        UpdateDAO<T>,
        SelectDAO<T> {
}
