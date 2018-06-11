package com.baizhi.service.Impl;

import com.baizhi.dao.ChiManagerDAO;
import com.baizhi.entity.ChiManager;
import com.baizhi.service.ChiManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/5/30.
 */

@Service         //创建Service对象，也可用@Component
@Transactional  //@Transactional 在类上加 类中所有方法都被加入了事务属性的默认值
                //@Transactional需要在查询方法上设置propagation,readonly
public class ChiManagerServiceImpl implements ChiManagerService {
    @Autowired(required = false)  //为自建类型注入（赋值）
    private ChiManagerDAO chiManagerDAO;

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void login(ChiManager chiManager1) {

        //查询
        ChiManager chiManager=chiManagerDAO.queryByName(chiManager1.getName());

        //判断
        if(chiManager==null){
            throw new RuntimeException("用户不存在");
        }else if(!chiManager.getPassword().equals(chiManager1.getPassword())){
            throw new RuntimeException("密码错误");
        }


    }
}
