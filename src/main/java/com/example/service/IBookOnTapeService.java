package com.example.service;

import com.example.model.BookOnTape;

import java.util.List;

public interface IBookOnTapeService {
    List<BookOnTape> findAll();
    BookOnTape findById(Long id);
}
