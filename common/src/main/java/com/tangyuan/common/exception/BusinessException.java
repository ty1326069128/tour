package com.tangyuan.common.exception;

import com.tangyuan.common.result.ResultCode;
import lombok.Data;
import org.springframework.util.StringUtils;


@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 2332608236621015980L;

    protected Integer code;

    protected String message;

    protected String consoleMsg;

    protected ResultCode resultCode;

    protected Object data;

    public BusinessException() {

    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(String format, Object... objects) {
        this();
        format = StringUtils.replace(format, "{}", "%s");
        this.message = String.format(format, objects);
    }

    public BusinessException(int code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
