package com.baizhi.controller;

import com.baizhi.service.UserService;
import com.baizhi.util.Md5Util;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.MD5;

/**
 * Created by Administrator on 2018/6/6.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;



    //--------------1. 一级页面接口------------------
    @RequestMapping(value = "/appmain")
    @ResponseBody
    public JSONObject appMain(String uid,String type,String sub_type){
        JSONObject jsonObject=new JSONObject();
        if("all".equals(type)){
            jsonObject.put("header",userService.getCarousel());
            jsonObject.put("album",userService.getAudio());
            jsonObject.put("article",userService.getChapter(uid));
            return  jsonObject;
        }else if("wen".equals(type)){
            jsonObject.put("album",userService.getAudio());
            return  jsonObject;
        }else if("si".equals(type)){
            if("ssyj".equals(sub_type)){
                jsonObject.put("article",userService.getChapter(uid));
                return jsonObject;
            }else if("xmfy".equals(sub_type)){
                jsonObject.put("article",userService.getChapters());
                return  jsonObject;
            }else {
                jsonObject.put("error",-200);
                return jsonObject;
            }
        }else{
            jsonObject.put("error",-200);
            return jsonObject;
        }
    }


    //-------------------3. 闻的详情页接口-----------------------
    @RequestMapping(value = "/appaudio")
    @ResponseBody
    public JSONObject appAudio(String id,String uid){
        JSONObject jsonObject=new JSONObject();
        //--------此处应该显示一个专辑详情，所以查一个，目前不对
        jsonObject.put("album",userService.getAudio());
        jsonObject.put("article",userService.getChapters());
        if(!jsonObject.get("album").equals(null)&&!jsonObject.get("article").equals(null)){
            return jsonObject;
        }else{
            jsonObject.put("error",-200);
            return jsonObject;
        }

    }
    //--------------------4. 登录接口-----还未做短信验证码登录！----！！！MD5加密！！---
    @RequestMapping(value = "/applogin")
    @ResponseBody
    public JSONObject appLogin(String phone,String password,String code){
        JSONObject jsonObject=new JSONObject();
        if(!password.equals(null)){
            String salt=userService.queryByPhone(phone).getSalt();
            String pass=password+salt;
            String md5= Md5Util.encryption(pass);
            if (md5.equals(userService.queryByPhone(phone).getPassword())){
                return jsonObject;
            }

        }
        return null;
    }


    //------------------5. 注册接口----------------------没MD5加密！！--------
    @RequestMapping(value = "/appregist")
    @ResponseBody
    public JSONObject appRegist(String phone,String password){
        JSONObject jsonObject=new JSONObject();

        if(password.equals(userService.queryByPhone(phone).getPassword())){
            jsonObject.put("User",userService.queryByPhone(phone));
            return jsonObject;
        }else{
            jsonObject.put("error",-200);
            jsonObject.put("error_msg","该手机号已存在");
            return jsonObject;
        }

    }


    //-------------------6. 修改个人信息接口---------------
    @RequestMapping(value = "/appupdate")
    @ResponseBody
    public JSONObject appUpdate(){
        return null;
    }


    //-------------------7. 获取短信验证码接口---------------
    @RequestMapping(value = "/appupdate")
    @ResponseBody
    public JSONObject appUpate(){
        return null;
    }


    //-------------------8. 短信验证码校验接口---------------
    @RequestMapping(value = "/app")
    @ResponseBody
    public JSONObject appUe(){
        return null;
    }


    //-------------------9. 获取会员列表接口---------------
    @RequestMapping(value = "/appgetvip")
    @ResponseBody
    public JSONObject appGetVIP(String uid){
        JSONObject jsonObject=new JSONObject();
        return null;

    }


}
