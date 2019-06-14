package com.exercise.sales.taxes.model.product;

import com.exercise.sales.taxes.model.tax.Taxes;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import static com.exercise.sales.taxes.model.tax.Taxes.roundTaxValue;

@Data
@SuperBuilder
@Builder
public class Product {

    private String name;
    private double price;
    private Taxes taxToApply;

    public double applyTaxes() {
        return getPrice() + calcTaxAmount();
    }

    public double calcTaxAmount() {
        return roundTaxValue(getPrice() * getTaxToApply().getRate() / 100);
    }

}
