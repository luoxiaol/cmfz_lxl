package com.baizhi.service;

import com.baizhi.entity.Audio;
import com.baizhi.entity.Carousel;
import com.baizhi.entity.Chapter;
import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2018/6/6.
 */
public interface UserService {
    void insert(User record);
    void deleteById(String id);
    void update(User user);
    User queryOne(String id);
    User queryByPhone(String id);
    List<User> queryAll();
    List<Carousel> getCarousel();
    List<Audio> getAudio();
    List<Chapter> getChapters();
    Chapter getChapter(String id);

}
