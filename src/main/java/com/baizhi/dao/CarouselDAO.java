
package com.baizhi.dao;

import com.baizhi.entity.Carousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
public interface CarouselDAO {
    public void insert(Carousel carousel);
    public void delete(Integer id);
    public void update(Carousel carousel);
    public Carousel queryById(Integer id);
    public Integer count();
    public List<Carousel> queryRows(@Param(value="page") Integer page,@Param(value="rows") Integer rows);
    public List<Carousel> queryAll();


}