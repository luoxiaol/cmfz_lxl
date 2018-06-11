package com.baizhi.controller;

import com.baizhi.entity.Audio;
import com.baizhi.service.AudioService;
import com.baizhi.util.FileParam;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.baizhi.util.FileUtil.IMG;


/**
 * Created by Administrator on 2018/6/5.
 */
@Controller
@RequestMapping(value="/audio")
public class AudioController {
    @Autowired
    private AudioService audioService;
    @RequestMapping(value="/add",produces = (MediaType.APPLICATION_JSON_VALUE))
    @ResponseBody
    public String add(Audio audio, MultipartFile image, HttpServletRequest request){
        /*
            1、获取文件存储位置
            2、重命名
            3、上传
        */
        FileParam param= FileUtil.uploadFile(image,request,IMG);
        audio.setCoverimg(param.getUrl());
        audioService.add(audio);
        return "success";
    }

    @RequestMapping(value = "/queryAll",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Audio> show(){
        List<Audio> all = audioService.queryAll();
        return all;
    }

    @RequestMapping(value = "/queryOne",produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String findOne(String id){
        Audio one = audioService.queryOne(id);
        return "one";
    }


}
