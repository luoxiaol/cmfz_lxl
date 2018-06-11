
package com.baizhi.service;

import com.baizhi.entity.Audio;

import java.util.List;

/**
 * Created by Administrator on 2018/6/5.
 */
public interface AudioService {
    public void add(Audio audio);
    public void update(Audio audio);
    public Audio queryOne(String id);
    public List<Audio> queryAll();

}
