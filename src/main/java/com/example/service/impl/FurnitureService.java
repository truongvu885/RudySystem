package com.example.service.impl;

import com.example.dao.IFurnitureDAO;
import com.example.model.Furniture;
import com.example.service.IFurnitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService implements IFurnitureService {

    @Autowired
    private IFurnitureDAO furnitureDAO;

    @Override
    public List<Furniture> findAll() {
        return furnitureDAO.findAll();
    }

    @Override
    public Furniture findById(Long id) {
        return furnitureDAO.findById(id);
    }
}
