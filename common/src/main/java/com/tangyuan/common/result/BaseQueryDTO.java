package com.tangyuan.common.result;

import lombok.Data;

@Data
public class BaseQueryDTO<T> {
    T condition;
    Integer pageNo = 1;
    Integer pageSize = 10;
}
