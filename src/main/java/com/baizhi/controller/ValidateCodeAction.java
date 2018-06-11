package com.baizhi.controller;

import com.baizhi.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Administrator on 2018/5/30.
 */
@Controller
@SessionAttributes(value="code") //大概等于跑马圈地，起个名
public class ValidateCodeAction {

    @RequestMapping(value="/yanzheng")
    public String createValidateCode(ModelMap map, OutputStream os){
        System.out.println("---------进入了验证码Action----------");
        //获取随机数
        CreateValidateCode cvc=new CreateValidateCode();
        String code=cvc.getCode();
        //将随机数存入session作用域
        map.addAttribute("code",code);  //在地里放东西
        //调用工具类画图
        try{
            cvc.write(os);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return null;
    }






}
