package com.baizhi.controller;

import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/6/4.
 */
@Controller
@RequestMapping(value="/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    /**
     *
     * @param carousel
     * @param
     * @return
     *
     * 数据模型层传数据，对象中的属性不必完整
     * String projectPath=request.getSession().getServletContext().getRealPath("/");
     * 还涉及文件上传到“页面”，然后存数据库
     */
    @RequestMapping(value="/add")
    @ResponseBody
    public String add(Carousel carousel,MultipartFile picture, HttpServletRequest request){

        //获取当前项目的路径
        String projectPath=request.getSession().getServletContext().getRealPath("/");
        //获取当前项目的文件
        File projectFile=new File(projectPath);
        //获取当前项目文件的父文件（路径）
        String webappPath=projectFile.getParent();
        //创建上传文件的存储路径
        File uploadFile=new File(webappPath+"/upload");


        //上传路径不存在，则创建
        if(!uploadFile.exists()){
            uploadFile.mkdir();
        }


        //----下面就是相关代码避免文件覆盖-----获取原始文件名
        String oldFilename=picture.getOriginalFilename();
        //获取原始文件的拓展名
        String extension= FilenameUtils.getExtension(oldFilename);
        //组建新文件名
        String newFilename= UUID.randomUUID().toString()+"."+extension;
        //上传文件------相当于创建一个新的文件
        try {
            picture.transferTo(new File(uploadFile.getPath()+"/"+newFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        carouselService.insert(carousel);
        return "";

    }
    @RequestMapping(value="/delete")
    @ResponseBody
    public String delete(Integer id){
        carouselService.delete(id);
        return "";
    }

    @RequestMapping(value="/update")
    @ResponseBody
    public String update(Carousel carousel){
        carouselService.update(carousel);
        return "";
    }
    @RequestMapping(value = "/queryOne")
    @ResponseBody
    public Carousel queryOne(Integer id){
        return carouselService.queryById(id);
    }
    public List<Carousel> queryAll(Integer page,Integer rows){
        return carouselService.queryRows(page,rows);
    }

    @RequestMapping(value = "/queryAll")
    @ResponseBody
    public List<Carousel> queryAllCarousel(){
        return carouselService.queryAll();
    }
}
