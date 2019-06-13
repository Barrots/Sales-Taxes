package com.exercise.sales.taxes.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuantityProduct {

    private Product product;
    private int quantity;

    public void print() {
        System.out.println(quantity + " " + product.getName() + " : " + product.applyTaxes());
    }
}
