package com.tangyuan.miniapp.service;

import com.tangyuan.trace.dto.RecordImage;
import com.tangyuan.trace.dto.RecordPoint;
import com.tangyuan.trace.dto.UserInfo;
import com.tangyuan.common.result.CommonDTO;

/**
 * Author tangyuan
 * Date  2019-10-18
 */
public interface WebMapService {

    CommonDTO getMiniAppHomeInfo();

    CommonDTO getUserMapNum(UserInfo userInfo);

    CommonDTO recordPoint(RecordPoint recordPoint);

    CommonDTO recordPointImage(RecordImage recordImage);

    CommonDTO getUserPointList(UserInfo userInfo);

    CommonDTO deletePoint(RecordPoint recordPoint);

    CommonDTO getArticleInfoById(Integer storyId);
}
