package com.example.model;

import com.example.dao.IVideoDAO;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class RentVideo extends Rent {
    Long videoId;

    @Autowired
    private IVideoDAO videoDAO;

    @Override
    public String getDescription() {
        return "Id: "+getId()+" |Rental date: "+getRentDate()+" |Expire date: "+getExpireDate()+" |Number rental day: "+getTotalDate()
                +" |Total money: "+getTotalMoney()+"$ |Video name: "+getName();
    }
}
