package com.example.model;

import lombok.*;

import java.sql.Time;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Video extends Thing{

    Integer length; // length of video /minute
    String category;
    String quality;

    @Override
    public String getDescription() {
        return "Id : "+getId()+" |Name : "+getName()+" |Issue date: "+getIssueDate()+" |Author: "+getAuthor()+" |Length: "+getLength()+" minute |Category: "+getCategory()
                +"|Quality: "+getQuality()+"p |Price: "+getPrice()+"$";
    }
}
