package com.baizhi.service.Impl;

import com.baizhi.dao.AudioDAO;
import com.baizhi.dao.CarouselDAO;
import com.baizhi.dao.ChapterDAO;
import com.baizhi.dao.UserDAO;
import com.baizhi.entity.Audio;
import com.baizhi.entity.Carousel;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/6.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CarouselDAO carouselDAO;
    @Autowired
    private AudioDAO audioDAO;
    @Autowired
    private ChapterDAO chapterDAO;

    public void insert(User record) {
        userDAO.insert(record);
    }

    public void deleteById(String id) {
        userDAO.deleteById(id);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public User queryOne(String id) {
        return null;
    }

    public User queryByPhone(String id) {
        return userDAO.queryByPhone(id);
    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<User> queryAll() {
        return null;
    }


    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Carousel> getCarousel(){
        return carouselDAO.queryAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Audio> getAudio(){
        return audioDAO.selectAll();
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Chapter> getChapters(){
        return chapterDAO.queryAll();
    }

    public Chapter getChapter(String id) {
        return chapterDAO.selectByPrimaryKey(id);
    }
}
