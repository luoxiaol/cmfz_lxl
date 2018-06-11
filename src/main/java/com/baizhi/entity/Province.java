package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/7.
 * 为统计地图而……无表
 */
public class Province implements Serializable {
    private String name;
    private Integer con;//省内人数

    public Province(String name, Integer con) {
        this.name = name;
        this.con = con;
    }

    public Province() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCon() {
        return con;
    }

    public void setCon(Integer con) {
        this.con = con;
    }

    @Override
    public String toString() {
        return "Province{" +
                "name='" + name + '\'' +
                ", con=" + con +
                '}';
    }
}
