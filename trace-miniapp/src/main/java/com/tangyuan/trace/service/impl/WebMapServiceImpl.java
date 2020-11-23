package com.tangyuan.trace.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.tangyuan.trace.dto.RecordImage;
import com.tangyuan.trace.dto.RecordPoint;
import com.tangyuan.trace.dto.UserInfo;
import com.tangyuan.trace.entity.StoryBannerEntity;
import com.tangyuan.trace.entity.StoryHomeEntity;
import com.tangyuan.trace.entity.StoryTraceEntity;
import com.tangyuan.trace.entity.StoryUserEntity;
import com.tangyuan.trace.vo.MapVo;
import com.tangyuan.trace.vo.StoryVO;
import com.tangyuan.trace.facade.StoryBannerFacade;
import com.tangyuan.trace.facade.StoryTraceFacade;
import com.tangyuan.trace.facade.StoryHomeFacade;
import com.tangyuan.trace.facade.StoryUserFacade;
import com.tangyuan.trace.service.WebMapService;
import com.tangyuan.result.CommonDTO;
import com.tangyuan.utils.FileUtils;
import com.tangyuan.utils.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tangyuan
 * @version 1.0
 * @date 2020/9/8 19:54
 */
@Slf4j
@Service
public class WebMapServiceImpl implements WebMapService {
    @Resource
    StoryTraceFacade storyTraceFacade;
    @Resource
    StoryHomeFacade storySelectionFacade;
    @Resource
    StoryUserFacade storyUserFacade;
    @Resource
    StoryBannerFacade storyBannerFacade;

    @Override
    public CommonDTO getMiniAppHomeInfo() {

        String content = "{\n" +
                "        \"bannerList\": [\n" +
                "            {\n" +
                "                \"poster\": \"https://ssyerv1.oss-cn-hangzhou.aliyuncs.com/picture/8f817b18c8384d9eb9881a94f35eb755.jpg!sswm\",\n" +
                "                \"title\": \"足迹故事，记录足迹，留下故事\",\n" +
                "                \"dataid\": \"ms1001\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"articleList\": [\n" +
                "            {\n" +
                "                \"poster\": \"https://ssyerv1.oss-cn-hangzhou.aliyuncs.com/picture/8f817b18c8384d9eb9881a94f35eb755.jpg!sswm\",\n" +
                "                \"title\": \"足迹故事，记录足迹，留下故事\",\n" +
                "                \"dataid\": \"ms1001\",\n" +
                "                \"addtime\": \"2020-07-01 12:00:00\",\n" +
                "                \"userInfo\": {\n" +
                "                    \"name\": \"小足迹\",\n" +
                "                    \"avatar\": \"http://cdn.521plus.com/avatar/default-head.jpg\"\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    }";

        //articleList
        List<StoryHomeEntity> storyHomeEntities = storySelectionFacade.findByStatus(1);
        List<MapVo.Article> articleList = storyHomeEntities.stream().map(storyHomeEntity -> {
            MapVo.Article article = new MapVo.Article();
            Integer storyId = storyHomeEntity.getStoryId();
            StoryTraceEntity storyTraceEntity = storyTraceFacade.findById(storyId);
            if (storyHomeEntity != null) {
                String images = storyTraceEntity.getImages();
                if (StrUtil.isNotBlank(images)) {
                    List<String> list = JSONUtil.toList(JSONUtil.parseArray(images), String.class);
                    if (list != null && list.size() > 0) {
                        HttpServletRequest request = SessionUtil.getRequest();
                        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/story/";
                        article.setPoster(baseUrl + FileUtils.getFolder(list.get(0)));
                    }
                }

                Integer userId = storyHomeEntity.getUserId();
                StoryUserEntity storyUserEntity = storyUserFacade.findById(userId);
                if (storyHomeEntity != null) {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setAvatar(storyUserEntity.getAvatarUrl());
                    userInfo.setName(storyUserEntity.getNickName());
                    article.setUserInfo(userInfo);
                }


                article.setTitle(storyTraceEntity.getTitle());
                article.setStoryId(storyId);
                article.setAddTime(storyHomeEntity.getCreatedAt());

            }

            return article;
        }).collect(Collectors.toList());

        //bannerList
        List<StoryBannerEntity> storyBannerEntities = storyBannerFacade.findAll();
        List<MapVo.Banner> bannerList = storyBannerEntities.stream().map(storyBannerEntity -> {
            MapVo.Banner banner = new MapVo.Banner();
            BeanUtil.copyProperties(storyBannerEntity, banner);

            HttpServletRequest request = SessionUtil.getRequest();
            String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/story/";
            banner.setPoster(baseUrl + FileUtils.getFolder(banner.getPoster()));

            return banner;
        }).collect(Collectors.toList());


        MapVo mapVo = new MapVo();
        mapVo.setArticleList(articleList);
        mapVo.setBannerList(bannerList);

        return CommonDTO.success(mapVo);
    }

    @Override
    public CommonDTO getUserMapNum(UserInfo userInfo) {

        UserInfo.SessionInfo sessionInfo = userInfo.getSessionInfo();

        if (isLogin(sessionInfo)) return CommonDTO.error(4001, "登录失败");

        String openId = sessionInfo.getOpenId();


        List<StoryUserEntity> storyUserEntities = storyUserFacade.findUserByOpenId(openId);
        if (storyUserEntities.size() > 0) {
            Integer id = storyUserEntities.get(0).getId();
            int count = storyTraceFacade.findStoryCountByUserId(id);

            return CommonDTO.success(count);
        }

        return CommonDTO.success(0);
    }

    @Override
    public CommonDTO recordPoint(RecordPoint recordPoint) {
        log.info("记录信息传入：" + recordPoint);
        String openId = recordPoint.getSessionInfo().getOpenId();
        List<StoryUserEntity> storyUserEntities = storyUserFacade.findUserByOpenId(openId);
        if (storyUserEntities == null || storyUserEntities.size() == 0) {
            return CommonDTO.error(4001, "登录失败");
        }

        StoryTraceEntity storyEntity = new StoryTraceEntity();

        BeanUtils.copyProperties(recordPoint, storyEntity);
        storyEntity.setUserId(storyUserEntities.get(0).getId());
        storyEntity.setLat(recordPoint.getLat());
        storyEntity.setLng(recordPoint.getLng());

        int row = storyTraceFacade.save(storyEntity);
        log.info("记录信息传出：" + row);
        if (row > 0) {
            return CommonDTO.success(storyEntity.getId());
        }

        return CommonDTO.error(4001, "创建失败");
    }

    @Override
    public CommonDTO recordPointImage(RecordImage recordImage) {
        log.info("记录信息传入：" + recordImage);
        Integer storyId = recordImage.getStoryId();
        StoryTraceEntity storyEntity = storyTraceFacade.findById(storyId);
        if (storyEntity == null) {
            return CommonDTO.error(4001, "足迹飞去外太空了!!!");
        }

        String imgList = recordImage.getImgList();
        if (StrUtil.isNotBlank(imgList)) {
            String images = JSONUtil.toJsonStr(imgList.split(","));
            storyEntity.setImages(images);
        }

        int row = storyTraceFacade.update(storyEntity);
        log.info("记录信息传出：" + row);
        if (row > 0) {
            return CommonDTO.success(row);
        }
        return CommonDTO.error(4001, "图片上传失败!");
    }

    @Override
    public CommonDTO getUserPointList(UserInfo userInfo) {
        UserInfo.SessionInfo sessionInfo = userInfo.getSessionInfo();
        if (sessionInfo == null) {
            return CommonDTO.error(4001, "登录失败");
        }

        String openId = sessionInfo.getOpenId();

        List<StoryUserEntity> storyUserEntities = storyUserFacade.findUserByOpenId(openId);
        if (storyUserEntities == null || storyUserEntities.size() == 0) {
            return CommonDTO.success(null);
        }

        Integer id = storyUserEntities.get(0).getId();
        List<StoryTraceEntity> storyEntities = storyTraceFacade.findStoryByUserId(id);

        HttpServletRequest request = SessionUtil.getRequest();
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/story/";

        List<StoryVO> storyVOS = storyEntities.stream().map(storyEntity -> getStoryVO(baseUrl, storyEntity)).collect(Collectors.toList());

        return CommonDTO.success(storyVOS);
    }

    @Override
    public CommonDTO deletePoint(RecordPoint recordPoint) {
        RecordPoint.SessionInfo sessionInfo = recordPoint.getSessionInfo();
        if (sessionInfo == null) {
            return CommonDTO.error(4001, "登录失败");
        }
        Integer storyId = recordPoint.getStoryId();
        int row = storyTraceFacade.deleteById(storyId);
        if (row > 0) {
            return CommonDTO.success(row);
        }
        return CommonDTO.error(4001, "删除失败!");
    }

    @Override
    public CommonDTO getArticleInfoById(Integer storyId) {

        HttpServletRequest request = SessionUtil.getRequest();
        String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/story/";

        StoryTraceEntity storyTraceEntity = storyTraceFacade.findById(storyId);
        StoryVO storyVO = getStoryVO(baseUrl, storyTraceEntity);

        return CommonDTO.success(storyVO);
    }

    //============
    private boolean isLogin(UserInfo.SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            return true;
        }
        return false;
    }

    private StoryVO getStoryVO(String baseUrl, StoryTraceEntity storyEntity) {
        StoryVO storyVO = new StoryVO();
        BeanUtils.copyProperties(storyEntity, storyVO);

        String images = storyEntity.getImages();
        List<String> imageList = new ArrayList<>();
        if (StrUtil.isNotBlank(images)) {
            List<String> list = JSONUtil.toList(JSONUtil.parseArray(images), String.class);

            for (String image : list) {
                imageList.add(baseUrl + FileUtils.getFolder(image));
            }

            storyVO.setImages(imageList);
        }

        return storyVO;
    }
}
