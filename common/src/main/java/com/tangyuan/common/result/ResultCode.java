package com.tangyuan.common.result;

import lombok.Getter;
import lombok.Setter;

public enum ResultCode {

    /* 成功状态码 */
    SUCCESS(0, "成功"),
    SYSTEM_INNER_ERROR(1, "系统繁忙，请稍后重试"),
    COMMON_EXCEPTION(2, "系统繁忙，请稍后重试"),
    PARAM_IS_INVALID(101, "参数无效");


    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
