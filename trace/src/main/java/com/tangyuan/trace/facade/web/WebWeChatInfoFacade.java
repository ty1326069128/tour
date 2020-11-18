package com.tangyuan.trace.facade.web;

import com.tangyuan.trace.dal.dto.MiniAppPhone;
import com.tangyuan.result.CommonDTO;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/8 20:27
 */
public interface WebWeChatInfoFacade {

    CommonDTO wxLogin(MiniAppPhone miniAppPhone);


}
