package com.baizhi.service;

import com.baizhi.entity.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/6/3.
 */
@Service
public interface MenuService {
    public List<Menu> queryAll();

}
