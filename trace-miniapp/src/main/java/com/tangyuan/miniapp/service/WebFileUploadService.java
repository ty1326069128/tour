package com.tangyuan.miniapp.service;

import com.tangyuan.common.result.CommonDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/18 15:34
 */
public interface WebFileUploadService {
    CommonDTO uploadImage(MultipartFile multipartFile);
}
