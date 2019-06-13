package com.exercise.sales.taxes.model.tax;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class BasicTaxTest {

    private static final double deltaApproximation = 0.0001;

    @Test
    public void testRate() {
        FreeTax tax = new BasicTax();
        assertEquals("BasicTax rate is not correct.", 10d, tax.getRate(), deltaApproximation);
    }

    @Test
    public void calcTax() {
        FreeTax tax = new BasicTax();
        assertEquals("", 20, tax.calcTax(200), deltaApproximation);
    }
}