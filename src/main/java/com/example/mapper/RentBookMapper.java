package com.example.mapper;

import com.example.dao.IBookOntapeDAO;
import com.example.dao.impl.BookOnTapeDAO;
import com.example.model.BookOnTape;
import com.example.model.RentBookOnTape;
import com.example.model.RentVideo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentBookMapper implements RowMapper<RentBookOnTape>{

    private IBookOntapeDAO bookOntapeDAO = new BookOnTapeDAO();
    @Override
    public RentBookOnTape mapRow(ResultSet resultSet) {
        RentBookOnTape rentBook = new RentBookOnTape();
        try{
            rentBook.setId(resultSet.getLong("id"));
            rentBook.setRentDate(resultSet.getTimestamp("rentDate"));
            rentBook.setExpireDate(resultSet.getTimestamp("expiredate"));
            rentBook.setName(bookOntapeDAO.findById(resultSet.getLong("bookTapeId")).getName());
            rentBook.setTotalDate(resultSet.getInt("totaldate"));
            rentBook.setTotalMoney(resultSet.getFloat("totalmoney"));
            return rentBook;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
