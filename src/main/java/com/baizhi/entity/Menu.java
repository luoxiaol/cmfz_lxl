package com.baizhi.entity;

import java.util.List;

/**
 * Created by Administrator on 2018/6/1.
 */
public class Menu {
    private Integer id;
    private String tittle;
    private String iconCls;
    private String parentId;
    private String url;
    private List<Menu> childList;

    public Menu(Integer id, String tittle, String iconCls, String parentId, String url, List<Menu> childList) {
        this.id = id;
        this.tittle = tittle;
        this.iconCls = iconCls;
        this.parentId = parentId;
        this.url = url;
        this.childList = childList;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parentId='" + parentId + '\'' +
                ", url='" + url + '\'' +
                ", childList=" + childList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getChildList() {
        return childList;
    }

    public void setChildList(List<Menu> childList) {
        this.childList = childList;
    }
}
