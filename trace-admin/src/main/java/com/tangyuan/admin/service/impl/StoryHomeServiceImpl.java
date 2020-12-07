package com.tangyuan.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.Page;
import com.tangyuan.admin.service.WebStoryHomeService;
import com.tangyuan.common.result.BaseQueryDTO;
import com.tangyuan.common.result.CommonDTO;
import com.tangyuan.trace.dto.ReqStoryHomeQueryDTO;
import com.tangyuan.trace.entity.StoryTraceEntity;
import com.tangyuan.trace.entity.StoryUserEntity;
import com.tangyuan.trace.enums.TraceStatusEnum;
import com.tangyuan.trace.facade.StoryTraceFacade;
import com.tangyuan.trace.facade.StoryUserFacade;
import com.tangyuan.trace.vo.AdminStoryTraceVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

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
    public CommonDTO getStoryHomeList(BaseQueryDTO<ReqStoryHomeQueryDTO> baseQueryDTO) {
        Condition condition = makeCondition(baseQueryDTO.getCondition());
        storyTraceFacade.findPageByCondition(condition,baseQueryDTO.getPageNo(),baseQueryDTO.getPageSize());
        Page<StoryTraceEntity> page = storyTraceFacade.findByStatus(condition, baseQueryDTO.getPageNo(), baseQueryDTO.getPageSize());
        List<AdminStoryTraceVO> adminStoryTraceVOS = page.getResult().stream().map(storyTraceEntity -> {
            AdminStoryTraceVO adminStoryTraceVO = new AdminStoryTraceVO();
            BeanUtil.copyProperties(storyTraceEntity, adminStoryTraceVO);

            Integer userId = adminStoryTraceVO.getUserId();
            StoryUserEntity storyUserEntity = storyUserFacade.findById(userId);
            if (storyUserEntity != null) {
                adminStoryTraceVO.setStoryUserEntity(storyUserEntity);
            }
            return adminStoryTraceVO;
        }).collect(Collectors.toList());
        return CommonDTO.restPage(page, adminStoryTraceVOS);
    }

    //======================
    private Condition makeCondition(ReqStoryHomeQueryDTO reqStoryHomeQueryDTO) {
        Condition condition = new Condition(StoryTraceEntity.class);
        if (reqStoryHomeQueryDTO != null) {
            Example.Criteria criteria = condition.createCriteria();
            Integer traceStatus = reqStoryHomeQueryDTO.getTraceStatus();
            TraceStatusEnum traceStatusEnum = TraceStatusEnum.getCode(traceStatus);
            if (traceStatusEnum != null) {
                int reviewStatus = traceStatusEnum.getReviewStatus();
                int status = traceStatusEnum.getStatus();
                criteria.andEqualTo("status", status)
                        .andEqualTo("reviewStatus", reviewStatus);
            }
        }
        condition.orderBy("createdAt").desc();
        return condition;
    }


}
