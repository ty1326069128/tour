package com.tangyuan.miniapp.service.impl;


import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import com.tangyuan.miniapp.service.WebWeChatInfoService;
import com.tangyuan.result.CommonDTO;
import com.tangyuan.trace.dto.MiniAppPhone;
import com.tangyuan.trace.entity.StoryUserEntity;
import com.tangyuan.trace.facade.StoryUserFacade;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/8 20:28
 */
@Service
public class WebWeChatInfoServiceImpl implements WebWeChatInfoService {
    @Resource
    WxMiniAppServiceImpl wxMiniAppService;
    @Resource
    StoryUserFacade storyUserFacade;

    @Override
    public CommonDTO wxLogin(MiniAppPhone miniAppPhone) {

        WxMaUserInfo wxMaUserInfo = wxMiniAppService.info(miniAppPhone);

        String openId = wxMaUserInfo.getOpenId();

        List<StoryUserEntity> storyUserEntities = storyUserFacade.findUserByOpenId(openId);
        if (storyUserEntities.size() == 0) {
            StoryUserEntity storyUserEntity = new StoryUserEntity();
            BeanUtil.copyProperties(wxMaUserInfo, storyUserEntity);
            storyUserEntity.setRegisterTime(new Timestamp(System.currentTimeMillis()));

            storyUserFacade.save(storyUserEntity);
        }

        JSONObject sessionInfo = new JSONObject();
        sessionInfo.put("openId", openId);

        return CommonDTO.success(sessionInfo);

    }


}
