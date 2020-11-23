package com.tangyuan.trace.vo;

import com.tangyuan.trace.entity.StoryTraceEntity;
import com.tangyuan.trace.entity.StoryUserEntity;
import lombok.Data;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/20 14:31
 */
@Data
public class AdminStoryTraceVO extends StoryTraceEntity {
    private StoryUserEntity storyUserEntity;
    private Integer traceStatus;
}
