package com.example.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class Furniture extends Thing{

    Float mass; //kg
    String material;

    @Override
    public String getDescription() {
        return "Id : "+getId()+" |Name : "+getName()+" |Issue date: "+getIssueDate()+" |Author: "+getAuthor()+" |Mass: "+getMass()+"kg |Material: "+getMaterial()
                +"|Price: "+getPrice()+"$";
    }

}
