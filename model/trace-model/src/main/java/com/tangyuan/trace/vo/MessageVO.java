package com.tangyuan.trace.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class MessageVO implements Serializable {

    private static final long serialVersionUID = -5424113637283045181L;

    private String messageId;
    private Integer sendUid;
    private Integer getUid;
    private Integer type;
    private Date postDate;
    private Integer groupId;
    private String content;
    private String status;

}
