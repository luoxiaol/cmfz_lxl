package com.baizhi.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by 木易 on 2018/5/31.
 */
public class FileUtil {
    //音频格式
    public static final String FILE="FILE";
    //图片格式
    public static final String IMG="IMG";

    public static FileParam uploadFile(MultipartFile multipartFile, HttpServletRequest request,String type){
        //当前项目位置
        String projectPath = request.getSession().getServletContext().getRealPath("/");
        //web项目的路径
        File file = new File(projectPath);
        String webappsPath = file.getParent();
        //1、判断要上传的文件格式，并创建对应的文件夹
        File uploadPath;
        String url;
        if(type.equals(FILE)){
            uploadPath=new File(webappsPath+"/audio");
            url="/audio";
        }else {
            uploadPath=new File(webappsPath+"/picture");
            url="/picture";
        }
        //2、如果上传文件夹不存在，则创建一个
        if(!uploadPath.exists()){
            uploadPath.mkdir();
        }
        //获取原始文件名   1.jpg   2.mp3
        String oldFilename = multipartFile.getOriginalFilename();
        //获取后缀名
        String extension = FilenameUtils.getExtension(oldFilename);
        //用uuid拼接后缀,生成新的文件名
        String uuid = UUID.randomUUID().toString();
        String newName = uuid + "." + extension;
        //上传到指定文件
        try {
            multipartFile.transferTo(new File(uploadPath.getPath(),newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回一个FileParam对象   url   oldName
        return new FileParam(url+"/"+newName,oldFilename);
    }

}
