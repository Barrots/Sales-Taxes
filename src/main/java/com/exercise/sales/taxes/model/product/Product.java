package com.exercise.sales.taxes.model.product;

import com.exercise.sales.taxes.model.tax.FreeTax;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Builder
public class Product {

    private String name;
    private double price;
    private FreeTax appliedTax;

    public double applyTaxes() {
        return price + appliedTax.calcTax(price);
    }

}
