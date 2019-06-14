package com.exercise.sales.taxes.model.product;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.exercise.sales.taxes.StarterApplicationTest.doubleDeltaApproximation;
import static com.exercise.sales.taxes.model.tax.Taxes.BASIC_TAX;
import static com.exercise.sales.taxes.model.tax.Taxes.FREE_TAX;
import static org.junit.Assert.assertEquals;

public class QuantityProductTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void print() {
        QuantityProduct quantityProduct = new QuantityProduct();
        quantityProduct.setProduct(null);
        quantityProduct.print();
        assertEquals("", outContent.toString());

        quantityProduct.setProduct(Product.builder().name("book").price(12.49).taxToApply(FREE_TAX).build());
        quantityProduct.setQuantity(1);
        quantityProduct.print();
        assertEquals("1 book: 12.49\n", outContent.toString());

    }

    @Test
    public void getTotal() {
        QuantityProduct quantityProduct = new QuantityProduct();
        quantityProduct.setQuantity(2);
        quantityProduct.setProduct(Product.builder().name("testProduct").price(12).taxToApply(BASIC_TAX).build());

        assertEquals("calculated Total is not correct", quantityProduct.getQuantity() * quantityProduct.getProduct().applyTaxes(), quantityProduct.getTotal(), doubleDeltaApproximation);

        quantityProduct.setProduct(null);
        assertEquals(0, quantityProduct.getTotal(), doubleDeltaApproximation);
        quantityProduct.setQuantity(0);
        assertEquals(0, quantityProduct.getTotal(), doubleDeltaApproximation);
    }

    @Test
    public void getTaxes() {
        QuantityProduct quantityProduct = new QuantityProduct();
        quantityProduct.setQuantity(2);
        quantityProduct.setProduct(Product.builder().name("testProduct").price(12).taxToApply(BASIC_TAX).build());

        assertEquals("calculated Taxes are not correct", quantityProduct.getQuantity() * quantityProduct.getProduct().calcTaxAmount(), quantityProduct.getTaxes(), doubleDeltaApproximation);
        quantityProduct.setProduct(null);
        assertEquals(0, quantityProduct.getTaxes(), doubleDeltaApproximation);
        quantityProduct.setQuantity(0);
        assertEquals(0, quantityProduct.getTaxes(), doubleDeltaApproximation);
    }
}