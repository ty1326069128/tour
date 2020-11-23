package com.tangyuan.trace.service.impl;

import com.tangyuan.result.CommonDTO;
import com.tangyuan.trace.entity.InnerMessageTextEntity;
import com.tangyuan.trace.facade.MessageFacade;
import com.tangyuan.trace.facade.MessageTextFacade;
import com.tangyuan.trace.service.WxUserCenterService;
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
    MessageFacade messageFacade;
    @Resource
    MessageTextFacade messageTextFacade;

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
