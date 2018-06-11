package com.baizhi.dao;

import com.baizhi.entity.ChiManager;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/5/30.
 */

public interface ChiManagerDAO {
    public ChiManager queryByName(String username);
}
