package com.tangyuan.trace.facade.web;

import com.tangyuan.trace.dto.RecordImage;
import com.tangyuan.trace.dto.RecordPoint;
import com.tangyuan.trace.dto.UserInfo;
import com.tangyuan.result.CommonDTO;

/**
 * Author tangyuan
 * Date  2019-10-18
 */
public interface WebMapFacade {

    CommonDTO getMiniAppHomeInfo();

    CommonDTO getUserMapNum(UserInfo userInfo);

    CommonDTO recordPoint(RecordPoint recordPoint);

    CommonDTO recordPointImage(RecordImage recordImage);

    CommonDTO getUserPointList(UserInfo userInfo);

    CommonDTO deletePoint(RecordPoint recordPoint);

    CommonDTO getArticleInfoById(Integer storyId);
}
