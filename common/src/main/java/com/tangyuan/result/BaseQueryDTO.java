package com.tangyuan.result;

import lombok.Data;

@Data
public class BaseQueryDTO<T> {
    T condition;
    int pageNo;
    int pageSize;
}
