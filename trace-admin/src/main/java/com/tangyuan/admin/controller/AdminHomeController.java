package com.tangyuan.admin.controller;

import com.tangyuan.admin.service.WebStoryHomeService;
import com.tangyuan.result.CommonDTO;
import com.tangyuan.result.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/20 10:40
 */
@ResponseResult
@RestController
@RequestMapping(value = "api/admin/home/")
public class AdminHomeController {
    private WebStoryHomeService webStoryHomeService;

    @GetMapping("/getStoryHomeList/{status}")
    public CommonDTO getStoryHomeList(@PathVariable Integer status) {
        return webStoryHomeService.getStoryHomeList(status);
    }
}
