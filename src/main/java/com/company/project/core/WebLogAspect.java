package com.company.project.core;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 */
@Aspect
@Component
public class WebLogAspect {

  ThreadLocal<Long> startTime = new ThreadLocal<>();

  public static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

  @Pointcut("execution(public * com.company.project.web..*.*(..))")
  public void webLog(){}

  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint){
    startTime.set(System.currentTimeMillis());

    // 接收到请求，记录请求内容
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    // 记录下请求内容
    logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    logger.info("URL : " + request.getRequestURL().toString());
    logger.info("HTTP_METHOD : " + request.getMethod());
    logger.info("IP : " + request.getRemoteAddr());
    logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
  }


  @AfterReturning(returning = "ret" ,pointcut = "webLog()")
  public void doAfterReturning(Object ret){
    logger.info("RESPONSE :"+ret);
    logger.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
  }

}
