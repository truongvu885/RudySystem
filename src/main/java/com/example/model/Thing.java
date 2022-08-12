package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public abstract class Thing {
    Long id;
    String name;
    Date issueDate;
    String author;
    Float price; //money of one day rent

    public abstract String getDescription();
}
