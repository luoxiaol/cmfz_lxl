package com.baizhi.dao;

import com.baizhi.entity.Audio;

import java.util.List;

public interface AudioDAO {
    void deleteByPrimaryKey(String id);

    void insert(Audio record);

    void insertSelective(Audio record);

    Audio selectByPrimaryKey(String id);

    void updateByPrimaryKeySelective(Audio record);

    void updateByPrimaryKey(Audio record);

    List<Audio> selectAll();
}