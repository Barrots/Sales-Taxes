package com.exercise.sales.taxes.model.tax;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BasicTax extends FreeTax {

    public final double rate = 10d;

}
