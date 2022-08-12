package com.example.service.impl;

import com.example.dao.IVideoDAO;
import com.example.model.Video;
import com.example.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class VideoService implements IVideoService {
    @Autowired
    private IVideoDAO videoDAO;

    @Override
    public List<Video> findAll() {
        return videoDAO.findAll();
    }

    @Override
    public List<Video> findByName(String name) {
        return videoDAO.findByName(name);
    }

    @Override
    public Video create(Video video) {
        Long id = videoDAO.create(video);
        return videoDAO.findById(id);
    }
}
