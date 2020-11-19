package com.tangyuan.trace.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangyuan.base.dal.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/18 17:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Table(name = "inner_message_text")
public class InnerMessageTextEntity extends BaseEntity {
    @Column(name = "send_id")
    private Integer sendId;
    @Column(name = "content")
    private String content;
    @Column(name = "group_id")
    private Integer groupId;
    @Column(name = "type")
    private Integer type;
    @Column(name = "post_date")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date postDate;
}
