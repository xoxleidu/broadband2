package com.zjts.broadband.common.log;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.zjts.broadband.common.model.LogInfo;
import com.zjts.broadband.system.model.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台系统日志 - 切点类
 * Created by ALEX on 2017/9/7.
 */
@Aspect
@Component
public class LogAOP {

    @Autowired
    MongoTemplate mongoTemplate;

    private String collectionName = "broadbandLog";

    //本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(LogAOP.class);

    //Service层切点
    @Pointcut("execution (* com.zjts.broadband.*.service.*.*(..)) @annotation(com.zjts.broadband.common.log.ServiceLog)")
    public void serviceAspect() {
    }
    //Controller层切点
    @Pointcut("@annotation(com.zjts.broadband.common.log.ControllerLog)")
    public void controllerAspect() {
    }

    /**
     * 环绕通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @After("controllerAspect()")
    public void doAround(JoinPoint  joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        try {
            Signature sig = joinPoint.getSignature();
            MethodSignature msig = null;
            if (!(sig instanceof MethodSignature)) {
                throw new IllegalArgumentException("该注解只能用于方法");
            }
            //*========数据库日志=========*//
            LogInfo map = new LogInfo();
//            Map<String, Object> map = new HashMap();
            //操作人姓名
//            SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
//            String userName = sysUser.getUsername();
            String userName = "";
            if (StringUtils.isBlank(userName)) {
                userName = "未知用户";
            }
            map.setUserName(userName);

            String ip = request.getRemoteAddr();
            //注解描述
            map.setDescription(getControllerMethodDescription(joinPoint));
            //获取类名和方法名
            map.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));

            //请求的IP
            map.setRequestIp(ip);
            map.setExceptionCode(null);
            map.setExceptionDetail(null);
            //获取方法参数
            String params = "";
            if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
                for (int i = 0; i < joinPoint.getArgs().length; i++) {
                    params += joinPoint.getArgs()[i] + ";";
                }
            }
            map.setParams(params);
            Enumeration<String> attributeNames = request.getSession().getAttributeNames();


            map.setCreateDate((Long)(new Date().getTime()));
            //保存数据库
 //           joinPoint.proceed();
            mongoTemplate.save(map);
            logger.info("保存日志成功:{}",map.toString());
        } catch (Exception e) {
            //记录本地异常日志
            e.printStackTrace();
            logger.error("记录本地系统日志异常");
            logger.error("异常信息:{}", e.getMessage());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error("记录本地系统日志异常");
            logger.error("异常信息:{}", throwable.getMessage());
        }
    }

    /**
     * 异常通知 用于拦截service层记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        try {
            //读取headUAC中的用户
//            SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
//            String userName = sysUser.getUsername();
              String userName = "";
            if (StringUtils.isBlank(userName)) {
                userName = "未知用户";
            }

            //获取请求ip
            String ip = request.getRemoteAddr();
            //获取用户请求方法的参数并序列化为JSON格式字符串
            String params = "";
            if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
                for (int i = 0; i < joinPoint.getArgs().length; i++) {
                    params += joinPoint.getArgs()[i].toString() + ";";
                }
            }
            /*==========数据库日志=========*/
            LogInfo map = new LogInfo();
            map.setDescription(getServiceMthodDescription(joinPoint));
            map.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            map.setRequestIp(ip);
            map.setExceptionCode(e.getClass().getName());
            map.setExceptionDetail(e.getMessage());
            map.setParams(params);
            map.setUserName(userName);
            map.setCreateDate((long)(new Date().getTime()));
            //保存数据库
            mongoTemplate.save(map);
        } catch (Exception ex) {
            //记录本地异常日志
            logger.error("记录系统异常信息异常");
            logger.error("异常信息:{}", ex.getMessage());
        }

    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getServiceMthodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

}
