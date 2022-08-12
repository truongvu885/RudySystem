package com.example.managerConsole;

import com.example.dao.IBookOntapeDAO;
import com.example.dao.IRentBookTapeDAO;
import com.example.dao.IRentVideoDAO;
import com.example.dao.IVideoDAO;
import com.example.dao.impl.BookOnTapeDAO;
import com.example.dao.impl.RentBookTapeDAO;
import com.example.dao.impl.RentVideoDAO;
import com.example.dao.impl.VideoDAO;
import com.example.model.BookOnTape;
import com.example.model.RentBookOnTape;
import com.example.model.RentVideo;
import com.example.model.Video;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentBookTapeManager {
    private IBookOntapeDAO bookOntapeDAO = new BookOnTapeDAO();
    private IRentBookTapeDAO rentBookTapeDAO = new RentBookTapeDAO();

    public void inputData() {

        System.out.println("Input your data");
        Scanner input = new Scanner(System.in);
        RentBookOnTape book = new RentBookOnTape();

        List<BookOnTape> bookList = bookOntapeDAO.findAll();
        List<String> videoNames = new ArrayList<>();
        for (BookOnTape b : bookList) {
            videoNames.add(b.getName());
        }
        for (String str : videoNames) {
            System.out.print("\t|" + str + "| ");
        }
        System.out.println();
        System.out.print("Choice video: ");
        String name = input.nextLine();
        BookOnTape book1 = bookOntapeDAO.findByName(name);
        System.out.print("Number of rental day: ");
        book.setTotalDate(Integer.parseInt(input.nextLine()));
        book.setBookTapeId(book1.getId());
        Timestamp tr = new Timestamp(System.currentTimeMillis());
        book.setRentDate(tr);
        int d = tr.getDate();
        d = d + book.getTotalDate();
        Timestamp te = new Timestamp(System.currentTimeMillis());// expireDate = rentDate + totalDate
        te.setDate(d);
        book.setExpireDate(te);
        book.setTotalMoney(book1.getPrice() * book.getTotalDate());
        Long id = rentBookTapeDAO.create(book);
        RentBookOnTape rentB = rentBookTapeDAO.findById(id);
        if (rentB != null) {
            System.out.println("Insert successful");
            System.out.println(rentB.getDescription());
        } else {
            System.err.println("Insert fail");
        }
    }

    public void showAll() {
        List<RentBookOnTape> list = rentBookTapeDAO.findAll();
        if (!list.isEmpty()) {
            for (RentBookOnTape b : list) {
                System.out.println(b.getDescription());
            }
        } else {
            System.err.println("Can't load data");
        }
    }
}
