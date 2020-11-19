package com.tangyuan.trace.controller;

import com.tangyuan.trace.facade.web.WebFileUploadFacade;
import com.tangyuan.result.CommonDTO;
import com.tangyuan.result.ResponseResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by tangyuan
 * on 2019/11/9 10:25
 */
@ResponseResult
@RestController
@RequestMapping(value = "/api/common/Public")
@CrossOrigin
public class FileUploadController {

    @Resource
    WebFileUploadFacade webFileUploadFacade;

    /**
     * 文件上传
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/uploadImage")
    public CommonDTO uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        CommonDTO commonDTO = webFileUploadFacade.uploadImage(file);
        return commonDTO;
    }

}
