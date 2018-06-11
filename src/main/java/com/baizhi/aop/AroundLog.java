package com.baizhi.aop;

import com.baizhi.entity.ChiManager;
import com.baizhi.service.Pic_LogService;
import org.apache.shiro.aop.MethodInterceptor;
import org.apache.shiro.aop.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/7.
 */
public class AroundLog implements MethodInterceptor {
    @Autowired
    private Pic_LogService pic_logService;
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //日志  什么人 什么时间 什么事 哪个管理员

        //什么人   从session里取

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        ChiManager  chiManager=(ChiManager) session.getAttribute("chiManager");
        String t_name   = chiManager.getName();

        //什么事  增删改需要日志  获得DML方法上的中文注释
        ChiManager method = invocation.getMethod();   //原始方法
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String t_thing=annotation.name();

        //什么时间
        Date t_date = new Date();

        System.out.println("kaishi==============================================");

        //执行结果
        String t_result="false";
        Object proceed=null;
        try {
            proceed = invocation.proceed();//放原始方法走
            t_result="true";    //执行到这没异常  成功
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //将结果放入数据库

        Pic_Log pic_log = new Pic_Log(null, t_name, t_thing, t_date, t_result);
        pic_logService.add(pic_log);
        System.out.println("end=============================================");

        return proceed;
    }
}
