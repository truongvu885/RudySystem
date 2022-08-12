package com.example.service;

import com.example.model.Furniture;

import java.util.List;

public interface IFurnitureService {
    List<Furniture> findAll();
    Furniture findById(Long id);
}
