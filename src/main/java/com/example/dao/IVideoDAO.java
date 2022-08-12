package com.example.dao;

import com.example.model.Video;

import java.util.List;

public interface IVideoDAO extends GenericDAO<Video>{
    List<Video> findAll();
    List<Video> findByName(String name);

    Video findById(Long id);
    Long create(Video video);
}
