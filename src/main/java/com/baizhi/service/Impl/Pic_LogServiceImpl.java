package com.baizhi.service.Impl;

import com.baizhi.dao.Pic_LogDAO;
import com.baizhi.entity.Pic_Log;
import com.baizhi.service.Pic_LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/6/7.
 */
@Service
@Transactional
public class Pic_LogServiceImpl implements Pic_LogService {
    @Autowired
    private  Pic_LogDAO pic_logDAO;
    public void add(Pic_Log pic_log) {
        pic_logDAO.insert(pic_log);
    }

}
