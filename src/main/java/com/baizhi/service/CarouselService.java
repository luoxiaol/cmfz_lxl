package com.baizhi.service;

import com.baizhi.entity.Carousel;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
public interface CarouselService {
    public void insert(Carousel carousel);
    public void delete(Integer id);
    public void update(Carousel carousel);
    public Carousel queryById(Integer id);
    public Integer count();
    public List<Carousel> queryRows(Integer page,  Integer rows);
    public List<Carousel> queryAll();
}
