package com.exercise.sales.taxes.service;

import com.exercise.sales.taxes.model.Receipt;
import com.exercise.sales.taxes.model.product.QuantityProduct;


public class ReceiptGenerator {

    private ReceiptGenerator(){}

    public static void printReceipt(Receipt receipt) {
        receipt.getQuantityProductList().forEach(QuantityProduct::print);
//        log.info("Sales Taxes: " + sales);
//        log.info("Total: " + total);
    }
}
