package com.exercise.sales.taxes.model.tax;

import org.junit.Test;

import static com.exercise.sales.taxes.StarterApplicationTest.doubleDeltaApproximation;
import static org.junit.Assert.assertEquals;

public class TaxesTest {

    @Test
    public void getRate() {
        assertEquals("Basic Tax value is not correct", 10, Taxes.BASIC_TAX.getRate(), doubleDeltaApproximation);
        assertEquals("Free Tax value is not correct", 0, Taxes.FREE_TAX.getRate(), doubleDeltaApproximation);
    }
}