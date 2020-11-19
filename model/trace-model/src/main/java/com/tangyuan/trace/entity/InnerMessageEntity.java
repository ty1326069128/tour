package com.tangyuan.trace.entity;

import com.tangyuan.base.dal.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/18 17:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "inner_message")
public class InnerMessageEntity extends BaseEntity {
    @Column(name = "user_id")
    private String userId;
    @Column(name = "open_id")
    private String openId;
    @Column(name = "message_id")
    private Integer messageId;
    @Column(name = "status")
    private Integer status;

}
