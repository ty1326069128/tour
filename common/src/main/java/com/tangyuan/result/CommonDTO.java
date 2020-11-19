package com.tangyuan.result;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.tangyuan.enums.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CommonDTO<T> implements Serializable {


    private Integer code;
    private String msg;
    private T data;

    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Long total = 1L;
    private List<T> list;


    public static <T> CommonDTO<T> success(T t) {
        CommonDTO<T> result = new CommonDTO<T>();
        result.setCode(ResultCode.SUCCESS.code());
        result.setMsg(ResultCode.SUCCESS.message());
        result.setData(t);
        return result;
    }


    public static <T> CommonDTO<T> error(Integer code, String message) {
        CommonDTO<T> result = new CommonDTO<T>();
        result.setCode(code);
        result.setMsg(message);
        return result;
    }

    public static <T> CommonDTO<T> error(Integer code, String message, T data) {
        CommonDTO<T> result = new CommonDTO<T>();
        result.setCode(code);
        result.setMsg(message);
        result.setData(data);
        return result;
    }

    public static CommonDTO error(ErrorCodeEnum codeEnum) {
        CommonDTO result = new CommonDTO();
        result.setCode(codeEnum.code());
        result.setMsg(codeEnum.msg());
        return result;
    }


    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> CommonDTO<T> restPage(List<T> list) {
        CommonDTO<T> result = new CommonDTO<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    /**
     * 将SpringData分页后的list转为分页信息
     */
    public static <T> CommonDTO<T> restPage(Page pageInfo, List<T> list) {
        CommonDTO<T> result = new CommonDTO<T>();
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(list);
        return result;
    }

}
