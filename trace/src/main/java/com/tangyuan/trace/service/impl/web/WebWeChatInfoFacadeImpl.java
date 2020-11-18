package com.tangyuan.trace.service.impl.web;


import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import com.tangyuan.trace.dal.dto.MiniAppPhone;
import com.tangyuan.trace.dal.entity.StoryUserEntity;
import com.tangyuan.trace.facade.record.StoryUserFacade;
import com.tangyuan.trace.facade.web.WebWeChatInfoFacade;
import com.tangyuan.trace.service.wechat.WxMiniAppService;
import com.tangyuan.result.CommonDTO;
import com.tangyuan.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/8 20:28
 */
@Service
public class WebWeChatInfoFacadeImpl implements WebWeChatInfoFacade {
    @Resource
    WxMiniAppService wxMiniAppService;
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
