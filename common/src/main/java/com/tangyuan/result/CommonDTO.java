package com.tangyuan.result;


import com.tangyuan.enums.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonDTO<T> implements Serializable {


    private Integer code;
    private String msg;
    private T data;


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
}
