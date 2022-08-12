package com.example.dao;

import com.example.model.BookOnTape;
import com.example.model.Furniture;

import java.util.List;

public interface IFurnitureDAO extends GenericDAO<Furniture>{
    List<Furniture> findAll();
    Furniture findById(Long id);

    Long create(Furniture furniture);
}
