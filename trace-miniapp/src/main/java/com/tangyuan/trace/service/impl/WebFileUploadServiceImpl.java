package com.tangyuan.trace.service.impl;

import com.tangyuan.result.CommonDTO;
import com.tangyuan.trace.service.WebFileUploadService;
import com.tangyuan.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/18 15:35
 */
@Slf4j
@Service
public class WebFileUploadServiceImpl implements WebFileUploadService {

    @Resource
    FileUtils fileUtils;

    @Override
    public CommonDTO uploadImage(MultipartFile multipartFile) {

        String filePath = fileUtils.upload(multipartFile, "story");

        return CommonDTO.success(filePath);
    }
}
