package com.tangyuan.base.dal;

import lombok.Data;

@Data
public class BaseQueryDTO<T> {
    T condition;
    int pageNo;
    int pageSize;
}
