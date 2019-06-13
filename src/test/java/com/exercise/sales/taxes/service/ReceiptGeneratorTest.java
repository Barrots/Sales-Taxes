package com.exercise.sales.taxes.service;

import com.exercise.sales.taxes.model.Receipt;
import com.exercise.sales.taxes.model.product.Product;
import com.exercise.sales.taxes.model.product.QuantityProduct;
import com.exercise.sales.taxes.model.tax.BasicTax;
import com.exercise.sales.taxes.model.tax.FreeTax;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ReceiptGeneratorTest {

    @Test
    public void printReceipt() {
        Product first = Product.builder()
                .name("book")
                .price(12.49)
                .appliedTax(new FreeTax())
                .build();
        Product second = Product.builder()
                .name("music CD")
                .price(14.99)
                .appliedTax(new BasicTax())
                .build();
        Product third = Product.builder()
                .name("chocolate bar")
                .price(0.85)
                .appliedTax(new FreeTax())
                .build();

        List<QuantityProduct> productList= Arrays.asList(
                new QuantityProduct(first, 1),
                new QuantityProduct(second, 1),
                new QuantityProduct(third, 1));

        Receipt receipt = new Receipt(productList);
        ReceiptGenerator.printReceipt(receipt);
    }
}