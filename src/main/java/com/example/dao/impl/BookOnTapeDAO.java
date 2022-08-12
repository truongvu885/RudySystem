package com.example.dao.impl;

import com.example.dao.IBookOntapeDAO;
import com.example.mapper.BookOnTapeMapper;
import com.example.model.BookOnTape;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookOnTapeDAO extends AbstractDAO<BookOnTape> implements IBookOntapeDAO {

    @Override
    public List<BookOnTape> findAll() {
        String sql = "select * from bookontape";
        return query(sql, new BookOnTapeMapper());
    }

    @Override
    public BookOnTape findById(Long id) {
        String sql = "select * from bookontape where id = ?";
        List<BookOnTape> list = query(sql,new BookOnTapeMapper(),id);
        if(!list.isEmpty()){
            return list.get(0);
        }
        else return null;
    }

    @Override
    public Long create(BookOnTape bookOnTape) {
        String sql = "insert into bookontape(name, issuedate, author, length, category, price) values (?,?,?,?,?,?);";
        return insert(sql,bookOnTape.getName(),bookOnTape.getIssueDate(),bookOnTape.getAuthor(),bookOnTape.getLength(),bookOnTape.getCategory(),bookOnTape.getPrice());
    }

    @Override
    public BookOnTape findByName(String name) {
        String sql = "select * from bookontape where name = ?";
        List<BookOnTape> list = query(sql,new BookOnTapeMapper(),name);
        if(!list.isEmpty()){
            return list.get(0);
        }
        else return null;
    }
}
