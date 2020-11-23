package com.tangyuan.trace.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangyuan.base.dal.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/24 18:23
 */
@Data
@Table(name = "story_home")
public class StoryHomeEntity extends BaseEntity {
    @Column(name = "story_id")
    private Integer storyId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "sort")
    private Integer sort;
    @Column(name = "status")
    private Integer status;
    @Column(name = "is_delete")
    private Integer isDelete;
    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updatedAt;

}
