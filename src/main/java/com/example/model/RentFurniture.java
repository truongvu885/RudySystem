package com.example.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class RentFurniture extends Rent{
    Long furnitureId;

    @Override
    public Float getTotalMoney() {
        return null;
    }

    @Override
    String getDescription() {
        return null;
    }
}
