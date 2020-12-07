package com.tangyuan.miniapp.service.impl;

import com.tangyuan.common.result.CommonDTO;
import com.tangyuan.trace.entity.InnerMessageTextEntity;
import com.tangyuan.miniapp.service.WxUserCenterService;
import com.tangyuan.trace.facade.InnerMessageFacade;
import com.tangyuan.trace.facade.InnerMessageTextFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/18 19:34
 */
@Slf4j
@Service
public class WxUserCenterServiceImpl implements WxUserCenterService {
    @Resource
    InnerMessageFacade messageFacade;
    @Resource
    InnerMessageTextFacade messageTextFacade;

    @Override
    public CommonDTO getInnerMessage(String openId) {
        int count = messageFacade.findCountByOpenId(openId);
        return CommonDTO.success(count);
    }

    @Override
    public CommonDTO lookMessage(String openId) {
        List<InnerMessageTextEntity> innerMessageTextEntities = messageTextFacade.messageTextFacade(openId);
        return CommonDTO.success(innerMessageTextEntities);
    }
}
