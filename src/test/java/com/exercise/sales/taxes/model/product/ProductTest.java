package com.exercise.sales.taxes.model.product;

import org.junit.Test;

import static com.exercise.sales.taxes.StarterApplicationTest.doubleDeltaApproximation;
import static com.exercise.sales.taxes.model.tax.Taxes.BASIC_TAX;
import static com.exercise.sales.taxes.model.tax.Taxes.FREE_TAX;
import static org.junit.Assert.assertEquals;

public class ProductTest {

    @Test
    public void calcTaxAmount() {
        Product product = ImportedProduct
                .builder()
                .name("testProduct with BasicTax")
                .price(27.99)
                .taxToApply(BASIC_TAX)
                .build();

        assertEquals(4.2, product.calcTaxAmount(), doubleDeltaApproximation);
    }

    @Test
    public void applyTaxes() {
        Product product = ImportedProduct
                .builder()
                .name("testProduct with BasicTax")
                .price(27.99)
                .taxToApply(BASIC_TAX)
                .build();

        //A Product's gross price should be equal to his net price plus the applied taxes
//        int desiredPrice = 120 + 120 / 10;
        double desiredPrice = 32.19;


        assertEquals("Gross price with BasicTax is not correct", desiredPrice, product.applyTaxes(), doubleDeltaApproximation);

        product = Product
                .builder()
                .name("testProduct with FreeTax")
                .price(120)
                .taxToApply(FREE_TAX)
                .build();

        desiredPrice = 120;
        assertEquals("Gross price with FreeTax is not correct", desiredPrice, product.applyTaxes(), doubleDeltaApproximation);

    }
}