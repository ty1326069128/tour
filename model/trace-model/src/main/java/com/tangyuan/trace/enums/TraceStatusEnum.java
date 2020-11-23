package com.tangyuan.trace.enums;

import lombok.Getter;

import java.util.Arrays;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/20 14:35
 */
@Getter
public enum TraceStatusEnum {
    //1.待审核 2.审核通过 3.未通过 4.已删除
    Pending(1, "待审核", 1, 1),
    passed(2, "已通过", 2, 1),
    Failed(3, "未通过", 3, 1),
    delete(4, "已删除", 0, 0),
    ;

    private int code;
    private String message;
    private int reviewStatus;
    private int status;

    TraceStatusEnum(int code, String message, int reviewStatus, int status) {
        this.code = code;
        this.message = message;
        this.reviewStatus = reviewStatus;
        this.status = status;
    }

    public static TraceStatusEnum getCode(Integer status) {
        return Arrays.asList(TraceStatusEnum.values()).stream()
                .filter(alarmGrade -> alarmGrade.getStatus() == status)
                .findFirst().get();
    }
}
