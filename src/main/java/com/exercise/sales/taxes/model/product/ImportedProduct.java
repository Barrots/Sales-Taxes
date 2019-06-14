package com.exercise.sales.taxes.model.product;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import static com.exercise.sales.taxes.model.tax.Taxes.roundTaxValue;

@Data
@SuperBuilder
public class ImportedProduct extends Product {

    private static final int importedTax = 5;

    @Override
    public String getName() {
        return "imported " + super.getName();
    }

    @Override
    public double calcTaxAmount() {
        return super.calcTaxAmount() + this.calcImportedTax();
    }


    private double calcImportedTax() {
        return roundTaxValue(getPrice() * importedTax / 100);
    }

}