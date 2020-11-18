package com.tangyuan.trace.security;

import com.tangyuan.trace.dal.entity.StoryUserEntity;
import com.tangyuan.trace.facade.record.StoryUserFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户登录认证信息查询
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    StoryUserFacade storyUserFacade;

    @Override
    public UserDetails loadUserByUsername(String openId) throws UsernameNotFoundException {
        List<StoryUserEntity> storyUserEntities = storyUserFacade.findUserByOpenId(openId);
        if (storyUserEntities == null || storyUserEntities.size() == 0) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        StoryUserEntity storyUserEntity = storyUserEntities.get(0);
        return new JwtUserDetails(storyUserEntity.getId(), storyUserEntity.getOpenId(), storyUserEntity.getNickName(), "");
    }
}