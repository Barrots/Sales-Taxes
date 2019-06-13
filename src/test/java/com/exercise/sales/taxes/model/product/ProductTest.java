package com.exercise.sales.taxes.model.product;

import com.exercise.sales.taxes.model.tax.BasicTax;
import com.exercise.sales.taxes.model.tax.FreeTax;
import org.junit.Test;

import static com.exercise.sales.taxes.StarterApplicationTest.doubleDeltaApproximation;
import static org.junit.Assert.assertEquals;

public class ProductTest {

    @Test
    public void applyTaxes() {
        Product product = Product
                .builder()
                .name("testProduct with Basic Tax")
                .price(120)
                .appliedTax(new BasicTax())
                .build();

        assertEquals("Gross price with BasicTax is not correct", 132d, product.applyTaxes(), doubleDeltaApproximation);

        product = Product
                .builder()
                .name("testProduct with FreeTax")
                .price(120)
                .appliedTax(new FreeTax())
                .build();

        assertEquals("Gross price with FreeTax is not correct", 120d, product.applyTaxes(), doubleDeltaApproximation);

    }
}