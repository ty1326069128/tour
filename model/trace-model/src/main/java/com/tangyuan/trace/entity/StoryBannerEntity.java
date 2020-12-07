package com.tangyuan.trace.entity;

import com.tangyuan.common.base.dal.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/10/30 11:21
 */
@Data
@Table(name = "story_banner")
public class StoryBannerEntity extends BaseEntity {
    @Column(name = "poster")
    private String poster;
    @Column(name = "title")
    private String title;
    @Column(name = "story_id")
    private Integer storyId;
}
