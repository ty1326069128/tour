package com.tangyuan.common.utils;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class LogAspectUtil {

    private LogAspectUtil() {

    }

    /**
     * 获取需要记录日志方法的参数，敏感参数用*代替
     *
     * @param joinPoint 切点
     * @return 去除敏感参数后的Json字符串
     */
    public static String getMethodParams(ProceedingJoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        if (arguments == null || arguments.length <= 0) {
            return sb.toString();
        }
        for (Object arg : arguments) {
            //移除敏感内容
            String paramStr;
            if (arg instanceof HttpServletResponse) {
                paramStr = HttpServletResponse.class.getSimpleName();
            } else if (arg instanceof HttpServletRequest) {
                paramStr = HttpServletRequest.class.getSimpleName();
            } else if (arg instanceof MultipartFile) {
                long size = ((MultipartFile) arg).getSize();
                paramStr = MultipartFile.class.getSimpleName() + " size:" + size;
            } else {
                paramStr = deleteSensitiveContent(arg);
            }
            sb.append(paramStr).append(",");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    /**
     * 删除参数中的敏感内容
     *
     * @param obj 参数对象
     * @return 去除敏感内容后的参数对象
     */
    public static String deleteSensitiveContent(Object obj) {
        JSONObject jsonObject = new JSONObject();
        if (obj == null || obj instanceof Exception) {
            return JSONUtil.toJsonStr(jsonObject);
        }
        String param = JSONUtil.toJsonStr(obj);
        try {
            jsonObject = JSONUtil.parseObj(param);
        } catch (Exception e) {
            return String.valueOf(obj);
        }
        List<String> sensitiveFieldList = getSensitiveFieldList();
        for (String sensitiveField : sensitiveFieldList) {
            if (jsonObject.containsKey(sensitiveField)) {
                jsonObject.put(sensitiveField, "******");
            }
        }
        return JSONUtil.toJsonStr(jsonObject);
    }

    /**
     * 敏感字段列表（当然这里你可以更改为可配置的）
     */
    private static List<String> getSensitiveFieldList() {
        List<String> sensitiveFieldList = Lists.newArrayList();
        sensitiveFieldList.add("pwd");
        sensitiveFieldList.add("password");
        return sensitiveFieldList;
    }
}
