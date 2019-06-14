package com.exercise.sales.taxes.model;

import com.exercise.sales.taxes.model.product.QuantityProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.List;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    private static final DecimalFormat f = new DecimalFormat("##0.00");

    private List<QuantityProduct> quantityProductList;

    public double calcTaxAmount() {
        return getQuantityProductList()
                .stream()
                .mapToDouble(QuantityProduct::getTaxes)
                .sum();
    }

    public double calcTotalAmount() {
        return getQuantityProductList()
                .stream()
                .mapToDouble(QuantityProduct::getTotal)
                .sum();
    }

    public void print() {
        if (getQuantityProductList() != null && !getQuantityProductList().isEmpty()) {
            getQuantityProductList().forEach(QuantityProduct::print);
            System.out.println("Sales Taxes: " + f.format(calcTaxAmount()));
            System.out.println("Total: " + f.format(calcTotalAmount()));
        } else {
            System.out.println("There's no Product to print yet.");
        }
    }

}

