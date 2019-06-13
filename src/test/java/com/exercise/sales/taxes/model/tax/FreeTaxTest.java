package com.exercise.sales.taxes.model.tax;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class FreeTaxTest {

    private static final double deltaApproximation = 0.0001;

    @Test
    public void calcTax() {
        FreeTax tax = new FreeTax();
        assertEquals("", 0, tax.calcTax(200), deltaApproximation);
    }

    @Test
    public void getRate() {
        FreeTax tax = new FreeTax();
        assertEquals("FreeTax rate is not correct.", 0d, tax.getRate(), deltaApproximation);
    }
}