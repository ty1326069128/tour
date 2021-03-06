package com.tangyuan.miniapp.controller;

import com.tangyuan.trace.dto.RecordImage;
import com.tangyuan.trace.dto.RecordPoint;
import com.tangyuan.trace.dto.UserInfo;
import com.tangyuan.miniapp.service.WebMapService;
import com.tangyuan.common.result.CommonDTO;
import com.tangyuan.common.result.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@ResponseResult
@RestController
@RequestMapping(value = "api/map/MapPc/")
public class WxMapController {

    @Resource
    private WebMapService webMapFacade;

    /**
     * 获取记录数量
     *
     * @param userInfo
     * @return
     */
    @PostMapping("/getUserMapNum")
    public CommonDTO getUserMapNum(@RequestBody UserInfo userInfo) {
        return webMapFacade.getUserMapNum(userInfo);
    }

    @PostMapping("/recordPoint")
    public CommonDTO recordPoint(@RequestBody RecordPoint recordPoint) {
        return webMapFacade.recordPoint(recordPoint);
    }

    @PostMapping("/recordPointImage")
    public CommonDTO recordPointImage(@RequestBody RecordImage recordImage) {
        return webMapFacade.recordPointImage(recordImage);
    }

    @PostMapping("/getUserPointList")
    public CommonDTO getUserPointList(@RequestBody UserInfo userInfo) {
        return webMapFacade.getUserPointList(userInfo);
    }

    @PostMapping("/deletePoint")
    public CommonDTO deletePoint(@RequestBody RecordPoint recordPoint) {
        return webMapFacade.deletePoint(recordPoint);
    }

    @PostMapping("/getPointsList")
    public CommonDTO getPointsList(@RequestBody UserInfo userInfo) {
        return webMapFacade.getUserPointList(userInfo);
    }
}
