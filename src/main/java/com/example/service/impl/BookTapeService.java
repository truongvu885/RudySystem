package com.example.service.impl;

import com.example.dao.IBookOntapeDAO;
import com.example.model.BookOnTape;
import com.example.service.IBookOnTapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTapeService implements IBookOnTapeService {

    @Autowired
    private IBookOntapeDAO bookOntapeDAO;

    @Override
    public List<BookOnTape> findAll() {
        return bookOntapeDAO.findAll();
    }

    @Override
    public BookOnTape findById(Long id) {
        return bookOntapeDAO.findById(id);
    }
}
