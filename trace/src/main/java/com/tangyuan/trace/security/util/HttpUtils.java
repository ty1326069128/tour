package com.tangyuan.trace.security.util;

import cn.hutool.json.JSONUtil;
import com.tangyuan.result.CommonDTO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HTTP工具类
 */
public class HttpUtils {

    /**
     * 获取HttpServletRequest对象
     *
     * @return
     */
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 输出信息到浏览器
     *
     * @param response
     * @param result
     * @throws IOException
     */
    public static void write(HttpServletResponse response, CommonDTO result) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        String json = JSONUtil.toJsonStr(result);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();
    }

}
