package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2018/6/3.
 */
@Controller
@RequestMapping(value="/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @RequestMapping(value="/allMenu")
    @ResponseBody
    public List<Menu> queryAll(){
        System.out.println("---------------------------------进入了方法----------------------------------------------------");
        return menuService.queryAll();
    }
}
