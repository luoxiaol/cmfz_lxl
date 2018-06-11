package com.baizhi.service.Impl;

import com.baizhi.dao.CarouselDAO;
import com.baizhi.entity.Carousel;
import com.baizhi.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/4.
 */
@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselDAO carouselDAO;


    public void insert(Carousel carousel) {

        carousel.setId(18);
        carouselDAO.insert(carousel);
    }

    public void delete(Integer id) {
        carouselDAO.delete(id);
    }

    public void update(Carousel carousel) {
        carouselDAO.update(carousel);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Carousel queryById(Integer id) {

        return carouselDAO.queryById(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Integer count() {
        return carouselDAO.count();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Carousel> queryRows(Integer page, Integer rows) {
        return carouselDAO.queryRows(page,rows);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Carousel> queryAll() {
        return carouselDAO.queryAll();
    }
}
