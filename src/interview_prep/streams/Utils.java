package interview_prep.streams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    //generate Product data
    public static List<Product> generateProductData() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple", new BigDecimal("1.20"), LocalDate.of(2024, 1, 1)));
        products.add(new Product("Orange", new BigDecimal("1.50"), LocalDate.of(2024, 1, 1)));
        products.add(new Product("Banana", new BigDecimal("0.50"), LocalDate.of(2024, 2, 3)));
        products.add(new Product("Grapes", new BigDecimal("2.00"), LocalDate.of(2024, 8, 31)));
        products.add(new Product("Pineapple", new BigDecimal("3.00"), LocalDate.of(2024, 9, 5)));
        products.add(new Product("Watermelon", new BigDecimal("4.00"), LocalDate.of(2024, 10, 6)));
        products.add(new Product("Strawberry", new BigDecimal("5.00"), LocalDate.of(2024, 10, 7)));
        products.add(new Product("Blueberry", new BigDecimal("6.00"), LocalDate.of(2024, 2, 8)));
        products.add(new Product("Raspberry", new BigDecimal("7.00"), LocalDate.of(2024, 10, 9)));
        products.add(new Product("Blackberry", new BigDecimal("8.00"), LocalDate.of(2024, 1, 1)));
        return products;
    }
}
