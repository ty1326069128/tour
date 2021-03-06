package com.tangyuan.common.result;

import cn.hutool.json.JSONUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlatformResult implements Result {
    private static final long serialVersionUID = 874200365941306385L;

    private Integer code;

    private String message;

    private Object data;

    public PlatformResult setCode(Integer code) {
        this.code = code;
        return this;
    }

    public PlatformResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public static PlatformResult success() {
        PlatformResult result = new PlatformResult();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static PlatformResult success(Object data) {
        PlatformResult result = new PlatformResult();
        result.setResultCode(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    public static PlatformResult failure(ResultCode resultCode) {
        PlatformResult result = new PlatformResult();
        result.setResultCode(resultCode);
        return result;
    }

    public static PlatformResult failure(ResultCode resultCode, Object data) {
        PlatformResult result = new PlatformResult();
        result.setResultCode(resultCode);
        result.setData(data);
        return result;
    }

    public static PlatformResult failure(String message) {
        PlatformResult result = new PlatformResult();
        result.setCode(ResultCode.PARAM_IS_INVALID.code());
        result.setMessage(message);
        return result;
    }

    private void setResultCode(ResultCode code) {
        this.code = code.code();
        this.message = code.message();
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonStr(this);
    }
}
