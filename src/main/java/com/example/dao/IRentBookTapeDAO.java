package com.example.dao;

import com.example.model.RentBookOnTape;
import com.example.model.RentVideo;

import java.util.List;

public interface IRentBookTapeDAO extends GenericDAO<RentBookOnTape> {

    Long create(RentBookOnTape rentBook);
    RentBookOnTape findById(Long id);

    List<RentBookOnTape> findAll();

}
