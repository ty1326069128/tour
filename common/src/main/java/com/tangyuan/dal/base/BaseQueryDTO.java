package com.tangyuan.dal.base;

import lombok.Data;

@Data
public class BaseQueryDTO<T> {
    T condition;
    int pageNo;
    int pageSize;
}
