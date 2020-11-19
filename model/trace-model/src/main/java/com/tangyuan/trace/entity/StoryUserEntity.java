package com.tangyuan.trace.entity;

import com.tangyuan.dal.base.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/24 18:23
 */
@Data
@Table(name = "story_user")
public class StoryUserEntity extends BaseEntity {
    private String openId;
    private String nickName;
    private String gender;
    private String language;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String unionId;
    private String appId;
    private Timestamp registerTime;
}
