package com.exercise.sales.taxes.model.tax;


import lombok.Data;

@Data
public class FreeTax {

    private final double rate = 0d;

    public double calcTax(double amount){
        return amount * getRate() / 100;
    }
}
