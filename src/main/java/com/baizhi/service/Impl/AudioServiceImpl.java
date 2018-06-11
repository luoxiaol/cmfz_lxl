package com.baizhi.service.Impl;

import com.baizhi.dao.AudioDAO;
import com.baizhi.entity.Audio;
import com.baizhi.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/6/5.
 */
@Service
public class AudioServiceImpl implements AudioService{
    @Autowired
    private AudioDAO audioDAO;

    public void add(Audio audio) {
        audio.setPublishdate(new Date());
        UUID uuid=UUID.randomUUID();
        String id=uuid.toString();
        audio.setId(id);
        audioDAO.insert(audio);

    }

    public void update(Audio audio) {
        audioDAO.updateByPrimaryKey(audio);

    }

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Audio queryOne(String id) {
        return audioDAO.selectByPrimaryKey(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Audio> queryAll() {
        return audioDAO.selectAll();
    }
}
