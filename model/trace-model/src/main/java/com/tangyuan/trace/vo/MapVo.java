package com.tangyuan.trace.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangyuan.trace.dto.UserInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/8 20:06
 */
@Data
@NoArgsConstructor
public class MapVo {

    private List<Banner> bannerList;
    private List<Article> articleList;

    @Data
    @NoArgsConstructor
    public static class Banner {
        private String poster;
        private String title;
        private Integer storyId;

    }

    @Data
    @NoArgsConstructor
    public static class Article {
        private String poster;
        private String title;
        private Integer storyId;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        private Timestamp addTime;
        private UserInfo userInfo;
    }
}
