package com.baizhi.dao;

import com.baizhi.entity.User;

import java.util.List;

public interface UserDAO {
    void insert(User record);
    void deleteById(String id);
    void update(User user);
    User queryOne(String id);
    List<User> queryAll();
    User queryByPhone(String id);

}