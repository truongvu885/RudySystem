package com.example.dao;

import com.example.model.RentVideo;

import java.util.List;

public interface IRentVideoDAO extends GenericDAO<RentVideo>{
    Long create(RentVideo rentVideo);
    RentVideo findById(Long id);

    List<RentVideo> findAll();
}
