package com.baizhi.service.Impl;

import com.baizhi.dao.MenuDAO;
import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/3.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDAO menuDAO;
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAll() {
        List<Menu> MenuList=menuDAO.queryAll();
        return  MenuList;
    }
}
