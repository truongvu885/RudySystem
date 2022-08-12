package com.example.mapper;

import com.example.model.BookOnTape;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookOnTapeMapper implements RowMapper<BookOnTape>{

    @Override
    public BookOnTape mapRow(ResultSet resultSet) {
        BookOnTape book = new BookOnTape();
        try{
            book.setId(resultSet.getLong("id"));
            book.setName(resultSet.getString("name"));
            book.setIssueDate(resultSet.getDate("issueDate"));
            book.setAuthor(resultSet.getString("author"));
            book.setLength(resultSet.getInt("length"));
            book.setCategory(resultSet.getString("category"));
            book.setPrice(resultSet.getFloat("price"));
            return book;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
