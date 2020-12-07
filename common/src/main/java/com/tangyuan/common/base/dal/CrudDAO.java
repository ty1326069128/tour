package com.tangyuan.common.base.dal;

public interface CrudDAO<T> extends
        InsertDAO<T>,
        DeleteDAO<T>,
        UpdateDAO<T>,
        SelectDAO<T> {
}
