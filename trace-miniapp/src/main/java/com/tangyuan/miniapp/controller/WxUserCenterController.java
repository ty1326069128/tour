package com.tangyuan.miniapp.controller;

import com.tangyuan.result.CommonDTO;
import com.tangyuan.result.ResponseResult;
import com.tangyuan.miniapp.service.WxUserCenterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/18 15:45
 */
@ResponseResult
@RestController
@RequestMapping(value = "api/map/user/")
public class WxUserCenterController {
    @Resource
    WxUserCenterService wxUserCenterFacade;

    /**
     * 获取用户站内信条数
     */
    @GetMapping("/getInnerMessage/{openId}")
    public CommonDTO getInnerMessage(@PathVariable String openId) {
        return wxUserCenterFacade.getInnerMessage(openId);
    }

    /**
     * 查看消息
     */
    @GetMapping("/lookMessage/{openId}")
    public CommonDTO lookMessage(@PathVariable String openId) {
        return wxUserCenterFacade.lookMessage(openId);
    }
}
