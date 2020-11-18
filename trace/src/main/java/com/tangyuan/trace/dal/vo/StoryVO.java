package com.tangyuan.trace.dal.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/24 19:33
 */
@Data
public class StoryVO {

    private int id;
    private String openId;

    private String title;

    private String story;

    private String address;

    private BigDecimal lng = BigDecimal.ZERO;

    private BigDecimal lat = BigDecimal.ZERO;

    private List<String> images;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updatedAt;
}
