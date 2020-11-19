package com.tangyuan.trace.controller;

import com.tangyuan.result.CommonDTO;
import com.tangyuan.result.ResponseResult;
import com.tangyuan.trace.facade.web.WebMapFacade;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/18 15:43
 */
@ResponseResult
@RestController
@RequestMapping(value = "api/map/MapPc/")
public class WxHomeController {
    @Resource
    private WebMapFacade webMapFacade;

    /**
     * 主页
     */
    @PostMapping("/getMiniAppHomeInfo")
    public CommonDTO getMiniAppHomeInfo() {
        return webMapFacade.getMiniAppHomeInfo();
    }

    @PostMapping("/getArticleInfoById/{storyId}")
    public CommonDTO getArticleInfoById(@PathVariable Integer storyId) {
        return webMapFacade.getArticleInfoById(storyId);
    }

}
