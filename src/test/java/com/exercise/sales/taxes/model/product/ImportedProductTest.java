package com.exercise.sales.taxes.model.product;

import org.junit.Test;

import static com.exercise.sales.taxes.StarterApplicationTest.doubleDeltaApproximation;
import static com.exercise.sales.taxes.model.tax.Taxes.BASIC_TAX;
import static org.junit.Assert.assertEquals;

public class ImportedProductTest {

    @Test
    public void applyTaxes() {
        double testPrice = 200;
        Product product = ImportedProduct
                .builder()
                .name("test ImportedProduct with Basic Tax")
                .price(testPrice)
                .taxToApply(BASIC_TAX)
                .build();

        //An imported product's gross price should be the net price + his Taxes (Basic in this example) + Imported Tax.
        double desiredPrice = testPrice + testPrice / 10 + testPrice / 20;

        assertEquals("Gross price of an imported product with BasicTax is not correct", desiredPrice, product.applyTaxes(), doubleDeltaApproximation);

    }
}