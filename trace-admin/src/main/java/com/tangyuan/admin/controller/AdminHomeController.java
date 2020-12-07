package com.tangyuan.admin.controller;

import com.tangyuan.admin.service.WebStoryHomeService;
import com.tangyuan.common.result.BaseQueryDTO;
import com.tangyuan.common.result.CommonDTO;
import com.tangyuan.common.result.ResponseResult;
import com.tangyuan.trace.dto.ReqStoryHomeQueryDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/20 10:40
 */
@ResponseResult
@RestController
@RequestMapping(value = "api/admin/home/")
public class AdminHomeController {
    @Resource
    private WebStoryHomeService webStoryHomeService;

    @PostMapping("/getStoryHomeList")
    public CommonDTO getStoryHomeList(@RequestBody BaseQueryDTO<ReqStoryHomeQueryDTO> baseQueryDTO) {
        return webStoryHomeService.getStoryHomeList(baseQueryDTO);
    }
}
