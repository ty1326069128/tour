package com.tangyuan.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.tangyuan.config.WebAppConfig;
import com.tangyuan.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by tangyuan
 * on 2019/9/23 19:00
 */
@Slf4j
@Component
public class FileUtils {

    @Value("${file.img}")
    private String imagesPath;

    /**
     * @param file    文件
     * @param catalog 文件存放路
     * @return
     */
    public String upload(MultipartFile file, String catalog) {
        //路径
        String path = getImageUrl() + "/" + catalog + "/";
        String fileNameSimple = getFileName(file.getOriginalFilename());
        path = path.replaceAll("file:", "") + DateUtil.format(new Date(), "yyyy-MM-dd");

        File filePath = new File(path);
        //是否存在img文件夹
        if (!filePath.getParentFile().exists()) {
            File parentFile = filePath.getParentFile();
            boolean mkdirs = parentFile.mkdirs();
            log.info("创建Img文件夹" + mkdirs);
        }

        //是否存在日文件夹
        if (!filePath.exists()) {
            filePath.mkdir();
        }

        String realPath = path + "/" + fileNameSimple;

        File dest = new File(realPath);
        try {
            //保存文件
            file.transferTo(dest);
            log.info("图片上传成功,图片地址:" + realPath);
            return fileNameSimple;
        } catch (IllegalStateException e) {
            return "";
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * 获取文件名称
     *
     * @param str
     * @return
     */
    public static String getFolder(String str) {
        if (StrUtil.isNotBlank(str)) {
            return str.substring(0, 10) + "/" + str;
        }
        return str;
    }

    //=========================

    /**
     * 生成新的文件名
     *
     * @param fileOriginName 源文件名
     * @return
     */
    private String getFileName(String fileOriginName) {
        String fileNameFix = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 13);

        String fileName = DateUtil.format(new Date(), "yyyy-MM-dd-HH-mm-ss") + "-" + fileNameFix;

        return fileName + fileName.substring(fileOriginName.lastIndexOf("."));
    }

    private String getImageUrl() {
        if (imagesPath.isEmpty()) {
            imagesPath = WebAppConfig.class.getClassLoader().getResource("").getPath();
            if (imagesPath.indexOf(".jar") > 0) {
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            } else if (imagesPath.indexOf("classes") > 0) {
                imagesPath = "file:" + imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/")) + "/img/";
        }
        return imagesPath;
    }
}

