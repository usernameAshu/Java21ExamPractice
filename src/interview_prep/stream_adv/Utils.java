package interview_prep.stream_adv;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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

    //generate list of Products with both Food and Drink types
    public static List<Product> generateMixedTypeProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Food("Apple", new BigDecimal("1.20"), LocalDate.of(2024, 1, 1)));
        products.add(new Food("Orange", new BigDecimal("1.50"), LocalDate.of(2024, 1, 1)));
        products.add(new Food("Banana", new BigDecimal("0.50"), LocalDate.of(2024, 2, 3)));
        products.add(new Food("Grapes", new BigDecimal("2.00"), LocalDate.of(2024, 8, 31)));
        products.add(new Food("Pineapple", new BigDecimal("3.00"), LocalDate.of(2024, 9, 5)));
        products.add(new Drink("Watermelon", new BigDecimal("4.00"), LocalDate.of(2024, 10, 6)));
        products.add(new Drink("Strawberry", new BigDecimal("5.00"), LocalDate.of(2024, 10, 7)));
        products.add(new Drink("Blueberry", new BigDecimal("6.00"), LocalDate.of(2024, 2, 8)));
        products.add(new Drink("Raspberry", new BigDecimal("7.00"), LocalDate.of(2024, 10, 9)));
        products.add(new Drink("Blackberry", new BigDecimal("8.00"), LocalDate.of(2024, 1, 1)));
        return products;

    }

    //generate Order data
    public static List<Order> generateOrderData() {
        List<Order> orders = new ArrayList<>();
        Product tea = new Drink("Tea", BigDecimal.valueOf(1.99), LocalDate.of(2019, 11, 21));
        Product cake = new Food("Cake", BigDecimal.valueOf(2.99), LocalDate.of(2019, 11, 21));
        Product coffee = new Drink("Coffee", BigDecimal.valueOf(1.99), LocalDate.of(2019, 11, 21));
        Order joe = new Order("Joe",
                LocalDate.of(2018, 11, 21),
                Arrays.asList(tea, cake));
        Order bob = new Order("Bob",
                LocalDate.of(2018, 11, 21),
                List.of(coffee));
        Order joe2 = new Order("Joe",
                LocalDate.of(2018, 11, 22),
                List.of(coffee,cake));
        orders.add(joe);
        orders.add(bob);
        orders.add(joe2);


        return orders;
    }
}
