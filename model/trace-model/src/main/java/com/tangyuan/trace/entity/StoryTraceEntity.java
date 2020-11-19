package com.tangyuan.trace.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangyuan.base.dal.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/24 18:23
 */
@Data
@Table(name = "story_trace")
public class StoryTraceEntity extends BaseEntity {
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "title")
    private String title;
    @Column(name = "story")
    private String story;
    @Column(name = "address")
    private String address;
    @Column(name = "lng")
    private BigDecimal lng = BigDecimal.ZERO;
    @Column(name = "lat")
    private BigDecimal lat = BigDecimal.ZERO;
    @Column(name = "images")
    private String images;
    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updatedAt;

}
