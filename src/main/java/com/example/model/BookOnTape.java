package com.example.model;


import lombok.*;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class BookOnTape extends Thing{

    Integer length; //minute
    String category;

    @Override
    public String getDescription() {
        return "Id : "+getId()+" |Name : "+getName()+" |Issue date: "+getIssueDate()+" |Author: "+getAuthor()+" |Length: "+getLength()+" minute |Category: "+getCategory()
                +" |Price: "+getPrice()+"$";
    }
}
