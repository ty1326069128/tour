package com.tangyuan.trace.service.impl;

import cn.binarywang.wx.miniapp.api.WxMaJsapiService;
import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaPhoneNumberInfo;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import cn.hutool.core.util.StrUtil;
import com.tangyuan.trace.config.WxMaConfiguration;
import com.tangyuan.trace.config.wx.WxMaProperties;
import com.tangyuan.trace.dto.MiniAppPhone;
import com.tangyuan.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/9 15:36
 */
@Service
@Slf4j
public class WxMiniAppServiceImpl {

    @Resource
    WxMaProperties wxMaProperties;

    /**
     * 登陆接口
     */
    public WxMaJscode2SessionResult login(String appId, String code) {
        if (StrUtil.isBlank(code)) {
            throw new BusinessException("empty jscode");
        }

        final WxMaService wxService = WxMaConfiguration.getMaService(appId);

        try {
            WxMaJscode2SessionResult session = wxService.getUserService().getSessionInfo(code);
            log.info(session.getSessionKey());
            log.info(session.getOpenid());
            //TODO 可以增加自己的逻辑，关联业务相关数据
            return session;
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
            throw new BusinessException(e.toString());
        }
    }

    /**
     * <pre>
     * 获取用户信息接口
     * </pre>
     */
    public WxMaUserInfo info(MiniAppPhone miniAppPhone) {
        List<WxMaProperties.Config> configs = wxMaProperties.getConfigs();
        String code = miniAppPhone.getCode();
        WxMaProperties.Config config = configs.get(0);
        String appId = config.getAppid();
        String sessionKey = this.sessionKey(code, appId);
        WxMaService wxService = WxMaConfiguration.getMaService(appId);
        WxMaUserService userService = wxService.getUserService();
        return userService.getUserInfo(sessionKey, miniAppPhone.getEncryoteData(), miniAppPhone.getIv());
    }

    /**
     * <pre>
     * 获取用户绑定手机号信息
     * </pre>
     */
    public WxMaPhoneNumberInfo phone(MiniAppPhone miniAppPhone) {
        String appId = miniAppPhone.getAppId();
        String sessionKey = miniAppPhone.getSessionKey();
        String encryptedData = miniAppPhone.getEncryoteData();
        String rawData = miniAppPhone.getRawData();
        String iv = getURLDecoderString(miniAppPhone.getIv());
        String signature = miniAppPhone.getSignature();

        final WxMaService wxService = WxMaConfiguration.getMaService(appId);

        // 用户信息校验
        WxMaUserService userService = wxService.getUserService();
        WxMaUserInfo userInfo1 = userService.getUserInfo(sessionKey, encryptedData, iv);
        boolean userInfo = userService.checkUserInfo(sessionKey, rawData, signature);
        if (!userInfo) {
            throw new BusinessException("user check failed");
        }

        // 解密
        WxMaPhoneNumberInfo phoneNoInfo = userService.getPhoneNoInfo(sessionKey, encryptedData, iv);

        return phoneNoInfo;
    }

    public String sessionKey(String code, String appId) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appId);
        try {
            WxMaJscode2SessionResult wxMaJscode2SessionResult = wxService.jsCode2SessionInfo(code);
            return wxMaJscode2SessionResult.getSessionKey();
        } catch (WxErrorException e) {
            log.error("获取sessionKey fail:", e);
        }
        return "";
    }

    public String signature(String appId, String code) {
        final WxMaService wxService = WxMaConfiguration.getMaService(appId);
        WxMaJsapiService jsapiService = wxService.getJsapiService();
        try {
            WxJsapiSignature wxJsapiSignature = jsapiService.createJsapiSignature(code);
            return wxJsapiSignature.getSignature();
        } catch (WxErrorException e) {
            log.error("获取signature fail:", e);
        }
        return "";
    }

    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
