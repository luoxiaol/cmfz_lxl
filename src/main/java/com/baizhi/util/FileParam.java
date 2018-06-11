package com.baizhi.util;

import java.io.Serializable;

/**
 * Created by 木易 on 2018/5/31.
 * 用于文件上传解决存储路径、命名方面的问题
 */
public class FileParam implements Serializable{
    private String url;
    private String oldName;

    public FileParam() {
    }

    public FileParam(String url, String oldName) {

        this.url = url;
        this.oldName = oldName;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    @Override
    public String toString() {
        return "FileParam{" +
                "url='" + url + '\'' +
                ", oldName='" + oldName + '\'' +
                '}';
    }
}
