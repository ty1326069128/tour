package com.tangyuan.common.aspect;


import com.tangyuan.common.exception.GlobalExceptionHandler;
import com.tangyuan.common.utils.GUIDGeneratorUtil;
import com.tangyuan.common.utils.IpUtil;
import com.tangyuan.common.utils.LogAspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class RestControllerAspect {


    /**
     * 环绕通知
     *
     * @param joinPoint 连接点
     * @return 切入点返回值
     * @throws Throwable 异常信息
     */
    @Around("@within(org.springframework.web.bind.annotation.RestController) || @annotation(org.springframework.web.bind.annotation.RestController)")
    public Object apiLog(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        boolean logFlag = this.needToLog(method);
        if (!logFlag) {
            return joinPoint.proceed();
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String userAgent = request.getHeader("user-agent");
        String ip = IpUtil.getRealIp(request);
        String methodName = this.getMethodName(joinPoint);
        String params = LogAspectUtil.getMethodParams(joinPoint);
        String uuid = GUIDGeneratorUtil.javaGUID();
        log.info("[{}]开始请求方法:[{}] 参数:[{}] IP:[{}] userAgent [{}]", uuid, methodName, params, ip, userAgent);
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        String deleteSensitiveContent = LogAspectUtil.deleteSensitiveContent(result);
        log.info("[{}]结束请求方法:[{}] 参数:[{}] 返回结果[{}] 耗时:[{}]毫秒 ", uuid,
                methodName, params, deleteSensitiveContent, end - start);
        return result;
    }

    private String getMethodName(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        String shortMethodNameSuffix = "(..)";
        if (methodName.endsWith(shortMethodNameSuffix)) {
            methodName = methodName.substring(0, methodName.length() - shortMethodNameSuffix.length());
        }
        return methodName;
    }


    /**
     * 判断是否需要记录日志
     */
    private boolean needToLog(Method method) {
        return method.getAnnotation(GetMapping.class) == null
                && !method.getDeclaringClass().equals(GlobalExceptionHandler.class);
    }

}
