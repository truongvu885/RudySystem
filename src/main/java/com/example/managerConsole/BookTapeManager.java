package com.example.managerConsole;

import com.example.dao.IBookOntapeDAO;
import com.example.dao.impl.BookOnTapeDAO;
import com.example.model.BookOnTape;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class BookTapeManager {

    private IBookOntapeDAO bookOntapeDAO = new BookOnTapeDAO();

    public void inputData(){
        BookOnTape book = new BookOnTape();
        Scanner input = new Scanner(System.in);
        System.out.println("Input book on tape data");
        System.out.print("Name: ");
        book.setName(input.nextLine());
        System.out.print("Issue date: ");
        book.setIssueDate(Date.valueOf(input.nextLine()));
        System.out.print("Author: ");
        book.setAuthor(input.nextLine());
        System.out.print("Price of one day: ");
        book.setPrice(Float.parseFloat(input.nextLine()));
        System.out.print("Category: ");
        book.setCategory(input.nextLine());
        System.out.print("Length: ");
        book.setLength(Integer.parseInt(input.nextLine()));
        Long id = bookOntapeDAO.create(book);
        BookOnTape b = bookOntapeDAO.findById(id);
        if(b!=null){
            System.out.println("Insert successful");
            System.out.println(b.getDescription());
        }else {
            System.err.println("Insert fail");
        }
    }

    public void showAll(){
        List<BookOnTape> list = bookOntapeDAO.findAll();
        if(!list.isEmpty()){
            for (BookOnTape b:list) {
                System.out.println(b.getDescription());
            }
        }
        else {
            System.err.println("Can't load data");
        }
    }
    public void findById(Long id){
        BookOnTape book = bookOntapeDAO.findById(id);
        if(book!=null){
            System.out.println(book.getDescription());
        }else {
            System.err.println("Can't find your id "+id);
        }
    }
}
