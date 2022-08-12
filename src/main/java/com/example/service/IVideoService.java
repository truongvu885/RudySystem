package com.example.service;

import com.example.model.Video;

import java.util.List;

public interface IVideoService {
    List<Video> findAll();
    List<Video> findByName(String name);

    Video create(Video video);
}
