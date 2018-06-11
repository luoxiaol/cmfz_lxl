package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/7.
 *
 * 记录轮播图相关操作
 */
public class Pic_Log implements Serializable {
    private Integer id;
    private String name;
    private String event;
    private Date time;
    private String result;

    public Pic_Log() {
    }

    public Pic_Log(Integer id, String name, String event, Date time, String result) {
        this.id = id;
        this.name = name;
        this.event = event;
        this.time = time;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Pic_Log{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", event='" + event + '\'' +
                ", time=" + time +
                ", result='" + result + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
