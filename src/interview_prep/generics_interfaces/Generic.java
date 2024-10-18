package interview_prep.generics_interfaces;

import java.math.BigDecimal;

public class Generic {
    public static void main(String[] args) {
        Some<Product> someProduct = new Some<>();
        someProduct.setValue(new Product("Tea", BigDecimal.TWO));

        Product value = someProduct.getValue();
    }
}
