package design_patterns.adapter;


import homework.lab3.RandomUtils;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Evgeny Borisov
 */
public class ProductRepo {

    private List<Supplier<? extends Costable>> products = List.of(Chair::new,Table::new);

    public Costable getProduct() {
        return RandomUtils.getRandomElement(products).get();
    }
}
