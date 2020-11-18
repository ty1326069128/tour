package com.tangyuan.trace.controller;

import com.tangyuan.trace.dal.dto.MiniAppPhone;
import com.tangyuan.trace.facade.web.WebWeChatInfoFacade;
import com.tangyuan.result.CommonDTO;
import com.tangyuan.result.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by tangyuan
 * on 2019/11/9 10:25
 */
@ResponseResult
@RestController
@RequestMapping(value = "/api/miniApp/MapBase/")
@CrossOrigin
public class WeChatController {

    @Resource
    WebWeChatInfoFacade webWeChatInfoFacade;

    /**
     * 登录
     *
     * @param miniAppPhone
     * @return
     */
    @PostMapping("/wxLogin")
    public CommonDTO wxLogin(@RequestBody MiniAppPhone miniAppPhone) {
        return webWeChatInfoFacade.wxLogin(miniAppPhone);
    }

}
