package com.example.mapper;

import com.example.model.Furniture;

import java.sql.ResultSet;

public class FurnitureMapper implements RowMapper<Furniture>{

    @Override
    public Furniture mapRow(ResultSet resultSet) {
        Furniture furniture = new Furniture();
        try{
            furniture.setId(resultSet.getLong("id"));
            furniture.setName(resultSet.getString("name"));
            furniture.setIssueDate(resultSet.getDate("issueDate"));
            furniture.setAuthor(resultSet.getString("author"));
            furniture.setMass(resultSet.getFloat("mass"));
            furniture.setMaterial(resultSet.getString("material"));
            furniture.setPrice(resultSet.getFloat("price"));
            return furniture;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
