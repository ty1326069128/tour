package com.tangyuan.trace.enums;

import lombok.Getter;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/18 17:52
 */
@Getter
public enum MessageEnum {
    STATUS_NOTREAD("未读"),
    STATUS_READ("已读"),
    STATUS_DELETED("已删除"),
    TYPE_SYSTEM("系统消息", 0),
    TYPE_PRIVATE("私信", 1),
    TYPE_NOTICE("站内通知", 2),
    GROUP_TYPE_USER("用户组", 0),
    GROUP_TYPE_ADMIN("管理组", 1);

    private Integer val;
    private String name;

    MessageEnum(String name, Integer val) {
        this.val = val;
        this.name = name;
    }

    MessageEnum(String name) {
        this.name = name;
    }
}
