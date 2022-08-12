package com.example.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class RentBookOnTape extends Rent{
    Long bookTapeId;

    @Override
    public Float getTotalMoney() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Id: "+getId()+" |Rental date: "+getRentDate()+" |Expire date: "+getExpireDate()+" |Number rental day: "+getTotalDate()
                +" |Total money: "+getTotalMoney()+"$ |Book on tape name: "+getName();
    }
}
