package com.baizhi.controller;


import com.baizhi.entity.ChiManager;
import com.baizhi.service.ChiManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * 管理员登录
 */
@Controller
@RequestMapping(value="/managerAction")
@SessionAttributes(value={"manager"})  //跑马圈地，先找个地以后放数据
public class ChiManagerLoginAction{

    @Autowired(required = false)
    private ChiManagerService cms;

    @RequestMapping(value="/login")
    public String login(HttpSession hs, ChiManager cm,String enCode){
        //验证码正确才进行接下的操作
        System.out.println("------------------进入了loginAction--------------------");
        System.out.println(cm);
        System.out.println(enCode);
        String code= (String) hs.getAttribute("code");
        if(code.equals(enCode)){
            cms.login(cm);
            hs.setAttribute("chiManager",cm);
            return "redirect:/main/main.jsp";
        }else{
            return "redirect:/login.jsp";
        }

    }

    @RequestMapping(value="/exit")
    public String exit(HttpSession hs, SessionStatus sessionStatus){
        hs.invalidate();             //销毁数据
        sessionStatus.setComplete(); //更改状态
        return "redirect:/login.jsp";

    }








}



