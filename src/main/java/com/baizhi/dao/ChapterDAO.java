package com.baizhi.dao;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterDAO {
    void deleteByPrimaryKey(String id);

    void insert(Chapter record);

    void insertSelective(Chapter record);

    Chapter selectByPrimaryKey(String id);

    void updateByPrimaryKeySelective(Chapter record);

    void updateByPrimaryKey(Chapter record);

    List<Chapter> queryAll();
}