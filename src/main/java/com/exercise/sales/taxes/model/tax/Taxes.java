package com.exercise.sales.taxes.model.tax;

public enum Taxes {
    FREE_TAX(0), BASIC_TAX(10);

    private final double rate;

    Taxes(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    /**
     * @param value needed to be rounderd
     * @return the nearest 0.05 double number rounded up.
     */
    public static double roundTaxValue(double value) {
        return Math.ceil((value * 20)) / 20.00d;
    }
}
