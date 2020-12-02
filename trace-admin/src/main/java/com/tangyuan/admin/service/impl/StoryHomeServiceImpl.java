package com.tangyuan.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.tangyuan.admin.service.WebStoryHomeService;
import com.tangyuan.enums.ErrorCodeEnum;
import com.tangyuan.result.CommonDTO;
import com.tangyuan.trace.entity.StoryTraceEntity;
import com.tangyuan.trace.entity.StoryUserEntity;
import com.tangyuan.trace.enums.TraceStatusEnum;
import com.tangyuan.trace.facade.StoryTraceFacade;
import com.tangyuan.trace.facade.StoryUserFacade;
import com.tangyuan.trace.vo.AdminStoryTraceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/11/20 11:24
 */
@Slf4j
@Service
public class StoryHomeServiceImpl implements WebStoryHomeService {
    @Resource
    StoryTraceFacade storyTraceFacade;
    @Resource
    StoryUserFacade storyUserFacade;

    @Override
    public CommonDTO getStoryHomeList(Integer traceStatus) {

        TraceStatusEnum traceStatusEnum = TraceStatusEnum.getCode(traceStatus);
        if (traceStatusEnum != null) {
            int reviewStatus = traceStatusEnum.getReviewStatus();
            int status = traceStatusEnum.getStatus();
            List<StoryTraceEntity> storyTraceEntities = storyTraceFacade.findByStatus(status, reviewStatus);
            List<AdminStoryTraceVO> adminStoryTraceVOS = storyTraceEntities.stream().map(storyTraceEntity -> {
                AdminStoryTraceVO adminStoryTraceVO = new AdminStoryTraceVO();
                BeanUtil.copyProperties(storyTraceEntity, adminStoryTraceVO);

                Integer userId = adminStoryTraceVO.getUserId();
                StoryUserEntity storyUserEntity = storyUserFacade.findById(userId);
                if (storyUserEntity != null) {
                    adminStoryTraceVO.setStoryUserEntity(storyUserEntity);
                }
                return adminStoryTraceVO;
            }).collect(Collectors.toList());
            return CommonDTO.success(adminStoryTraceVOS);
        }
        return CommonDTO.error(ErrorCodeEnum.GL99990100);
    }
}
