package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public abstract class Rent {
    Long id;
    Timestamp expireDate;
    Timestamp rentDate;
    Integer totalDate; // number of rental days
    Float totalMoney;
    String name;

    abstract String getDescription();
}
