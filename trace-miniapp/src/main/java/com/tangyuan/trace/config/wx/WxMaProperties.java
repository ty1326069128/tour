package com.tangyuan.trace.config.wx;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Created by tangyuan
 * on 2019/12/5 12:09
 */
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Component
@ConfigurationProperties(prefix = "wx.miniapp")
@Data
@ToString
public class WxMaProperties {

    private List<Config> configs;

    @Data
    public static class Config {
        /**
         * 设置微信小程序的appid
         */
        private String appid;

        /**
         * 小程序名称
         */
        private String appName;

        /**
         * 设置微信小程序的Secret
         */
        private String secret;

        /**
         * 设置微信小程序消息服务器配置的token
         */
        private String token;

        /**
         * 设置微信小程序消息服务器配置的EncodingAESKey
         */
        private String aesKey;

        /**
         * 消息格式，XML或者JSON
         */
        private String msgDataFormat;
    }

}
