package com.exercise.sales.taxes.model;

import com.exercise.sales.taxes.model.product.ImportedProduct;
import com.exercise.sales.taxes.model.product.QuantityProduct;
import com.exercise.sales.taxes.model.tax.Taxes;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.exercise.sales.taxes.StarterApplicationTest.doubleDeltaApproximation;
import static org.junit.Assert.assertEquals;

public class ReceiptTest {

    private Receipt receiptTest;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        receiptTest = new Receipt();

        QuantityProduct quantityProduct = new QuantityProduct(ImportedProduct.builder()
                .name("box of chocolates")
                .price(10)
                .taxToApply(Taxes.FREE_TAX)
                .build(), 1);
        QuantityProduct quantityProduct2 = new QuantityProduct(ImportedProduct.builder()
                .name("bottle of perfume")
                .price(47.50)
                .taxToApply(Taxes.BASIC_TAX)
                .build(), 1);

        List<QuantityProduct> quantityProducts = Arrays.asList(quantityProduct, quantityProduct2);
        receiptTest.setQuantityProductList(quantityProducts);

    }

    @Test
    public void calcTaxAmount() {
        assertEquals("Tax amount in the Receipt is not correct", 7.65, receiptTest.calcTaxAmount(), doubleDeltaApproximation);

    }

    @Test
    public void calcTotalAmount() {
        assertEquals("Total amount in the Receipt is not correct", 65.15, receiptTest.calcTotalAmount(), doubleDeltaApproximation);
    }

    @Test
    public void print() {
        System.setOut(new PrintStream(outContent));
        receiptTest.print();
        assertEquals("1 imported box of chocolates: 10.50\n" +
                "1 imported bottle of perfume: 54.65\n" +
                "Sales Taxes: 7.65\n" +
                "Total: 65.15\n", outContent.toString());
    }

    @Test
    public void voidPrint() {
        System.setOut(new PrintStream(outContent));
        receiptTest.setQuantityProductList(new ArrayList<>());
        receiptTest.print();
        assertEquals("There's no Product to print yet.\n", outContent.toString());

        System.setOut(originalOut);

    }
}