package com.example.dao.impl;

import com.example.dao.IRentBookTapeDAO;
import com.example.mapper.RentBookMapper;
import com.example.model.BookOnTape;
import com.example.model.RentBookOnTape;

import java.util.List;

public class RentBookTapeDAO extends AbstractDAO<RentBookOnTape> implements IRentBookTapeDAO {

    @Override
    public Long create(RentBookOnTape rentBook) {
        String sql = "insert into rentbooktape(rentdate, expiredate, totaldate, totalmoney, bookTapeId) " +
                " values(?,?,?,?,?)";

        return insert(sql,rentBook.getRentDate(),rentBook.getExpireDate(),rentBook.getTotalDate(),rentBook.getTotalMoney(),rentBook.getBookTapeId());
    }

    @Override
    public RentBookOnTape findById(Long id) {
        String sql = "select * from rentbooktape where id = ?";
        List<RentBookOnTape> list = query(sql,new RentBookMapper(),id);
        if(!list.isEmpty()){
            return list.get(0);
        }
        else return null;
    }

    @Override
    public List<RentBookOnTape> findAll() {
        String sql = "select * from rentbooktape";
        return query(sql,new RentBookMapper());
    }
}
