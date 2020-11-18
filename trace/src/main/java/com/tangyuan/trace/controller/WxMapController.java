package com.tangyuan.trace.controller;

import com.tangyuan.trace.dal.dto.RecordImage;
import com.tangyuan.trace.dal.dto.RecordPoint;
import com.tangyuan.trace.dal.dto.UserInfo;
import com.tangyuan.trace.facade.web.WebMapFacade;
import com.tangyuan.result.CommonDTO;
import com.tangyuan.result.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@ResponseResult
@RestController
@RequestMapping(value = "api/map/MapPc/")
public class WxMapController {

    @Resource
    private WebMapFacade webMapFacade;

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
