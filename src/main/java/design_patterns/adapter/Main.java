package design_patterns.adapter;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        Costable product = productRepo.getProduct();

        ProductHandler productHandler = new ProductHandler();
        ProductHandlerAdapter productHandlerAdapter = new ProductHandlerAdapter(productHandler);

        productHandlerAdapter.handle(product);
    }
}
