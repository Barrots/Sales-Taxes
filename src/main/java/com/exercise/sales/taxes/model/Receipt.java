package com.exercise.sales.taxes.model;

import com.exercise.sales.taxes.model.product.QuantityProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
@AllArgsConstructor
public class Receipt {

    private List<QuantityProduct> quantityProductList;

}

