package com.exercise.sales.taxes;

import com.exercise.sales.taxes.model.Receipt;
import com.exercise.sales.taxes.model.product.ImportedProduct;
import com.exercise.sales.taxes.model.product.Product;
import com.exercise.sales.taxes.model.product.QuantityProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static com.exercise.sales.taxes.model.tax.Taxes.BASIC_TAX;
import static com.exercise.sales.taxes.model.tax.Taxes.FREE_TAX;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@SpringBootTest
public class StarterApplicationTest {

    public static final double doubleDeltaApproximation = 0.0001;

    @Test
    public void simulateInput1() {
        QuantityProduct book = new QuantityProduct(Product.builder()
                .name("book")
                .price(12.49)
                .taxToApply(FREE_TAX)
                .build(), 1);
        QuantityProduct musicCd = new QuantityProduct(Product.builder()
                .name("music CD")
                .price(14.99)
                .taxToApply(BASIC_TAX)
                .build(), 1);
        QuantityProduct chocolate = new QuantityProduct(Product.builder()
                .name("chocolate bar")
                .price(0.85)
                .taxToApply(FREE_TAX)
                .build(), 1);

        Receipt receipt1 = new Receipt(Arrays.asList(book, musicCd, chocolate));

        System.out.println("\nOutput 1:");
        receipt1.print();
    }


    @Test
    public void simulateInput2() {
        QuantityProduct chocolates = new QuantityProduct(ImportedProduct.builder()
                .name("box of chocolates")
                .price(10)
                .taxToApply(FREE_TAX)
                .build(), 1);
        QuantityProduct porfume = new QuantityProduct(ImportedProduct.builder()
                .name("bottle of porfume")
                .price(47.5)
                .taxToApply(BASIC_TAX)
                .build(), 1);

        Receipt receipt2 = new Receipt(Arrays.asList(chocolates, porfume));

        System.out.println("\nOutput 2:");
        receipt2.print();
    }

    @Test
    public void simulateInput3() {
        QuantityProduct importedPorfume = new QuantityProduct(ImportedProduct.builder()
                .name("bottle of porfume")
                .price(27.99)
                .taxToApply(BASIC_TAX)
                .build(), 1);

        QuantityProduct porfume = new QuantityProduct(Product.builder()
                .name("bottle of porfume")
                .price(18.99)
                .taxToApply(BASIC_TAX)
                .build(), 1);

        QuantityProduct pills = new QuantityProduct(Product.builder()
                .name("packet of headache pills")
                .price(9.75)
                .taxToApply(FREE_TAX)
                .build(), 1);

        QuantityProduct chocolates = new QuantityProduct(ImportedProduct.builder()
                .name("box of chocolates")
                .price(11.25)
                .taxToApply(FREE_TAX)
                .build(), 1);

        Receipt receipt3 = new Receipt(Arrays.asList(importedPorfume, porfume, pills, chocolates));

        System.out.println("\nOutput 3:");
        receipt3.print();
    }

}