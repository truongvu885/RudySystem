package com.example.dao.impl;

import com.example.dao.IFurnitureDAO;
import com.example.mapper.FurnitureMapper;
import com.example.model.Furniture;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FurnitureDAO extends AbstractDAO<Furniture> implements IFurnitureDAO {


    @Override
    public List<Furniture> findAll() {
        String sql = "select * from furniture";
        return query(sql,new FurnitureMapper());
    }

    @Override
    public Furniture findById(Long id) {
        String sql = "select * from furniture where id = ?";
        List<Furniture> list = query(sql,new FurnitureMapper(),id);
        if(!list.isEmpty()){
            return list.get(0);
        }
        else return null;
    }

    @Override
    public Long create(Furniture furniture) {
        String sql = "insert into furniture(name, issuedate, author, mass,material, price)\n" +
                "values (?,?,?,?,?,?);";
        return insert(sql, furniture.getName(),furniture.getIssueDate(),furniture.getAuthor(),furniture.getMass(),furniture.getMaterial(),furniture.getPrice());
    }
}
