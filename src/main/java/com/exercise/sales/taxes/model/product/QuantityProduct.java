package com.exercise.sales.taxes.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantityProduct {

    private static final DecimalFormat f = new DecimalFormat("##0.00");
    private Product product;
    private int quantity;

    public void print() {
        if (quantity > 0 && product != null) {
            System.out.println(getQuantity() + " " + getProduct().getName() + ": " + f.format(getProduct().applyTaxes()));
        }
    }

    public double getTotal() {
        if (quantity > 0 && product != null)
            return getQuantity() * getProduct().applyTaxes();
        return 0;
    }

    public double getTaxes() {
        if (quantity > 0 && product != null)
            return getQuantity() * getProduct().calcTaxAmount();
        return 0;
    }
}
