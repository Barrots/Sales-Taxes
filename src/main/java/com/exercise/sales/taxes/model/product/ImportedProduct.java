package com.exercise.sales.taxes.model.product;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ImportedProduct extends Product {

    @Override
    public double applyTaxes() {
        return super.applyTaxes() + this.calcImportedTax();
    }

    private double calcImportedTax() {
        return this.getPrice() * 0.05;
    }

}