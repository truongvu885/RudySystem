package com.example.dao;

import com.example.model.BookOnTape;

import java.util.List;

public interface IBookOntapeDAO extends GenericDAO<BookOnTape>{
    List<BookOnTape> findAll();
    BookOnTape findById(Long id);

    Long create(BookOnTape bookOnTape);

    BookOnTape findByName(String name);
}
