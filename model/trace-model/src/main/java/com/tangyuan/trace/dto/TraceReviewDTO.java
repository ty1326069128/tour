package com.tangyuan.trace.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TraceReviewDTO {
    private Integer traceId;
    private ReviewStatus reviewStatus;
    private Integer status;

    @Data
    public class ReviewStatus {
        private Integer status;
        private String describe;
        private String remark;
    }
}
