package interview_prep.stream_adv;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectOps {

    public static void main(String[] args) {
        new CollectOps().test2();
        Comparator<String> comp = (s1, s2) -> s1.compareTo(s2);

    }

    public void test2() {
        List<Order> orders = Utils.generateOrderData();

        //print the orders:
        System.out.println("---------------------------");
        System.out.println(orders);
        System.out.println("---------------------------");

        //show a map of Customer with their unique items in all orders
        Map<String, Set<String>> custItems = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer(),
                        Collectors.flatMapping(order -> order.getItems().stream().map(Product::getName).toList().stream(),
                                Collectors.toSet())));

        System.out.println(custItems);

        //Map customers to the total order values till date
        Map<String, Double> custOrdVal = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer,
                        Collectors.flatMapping(order -> order.getItems().stream()
                                        .map(Product::getPrice)
                                        .toList().stream(),
                                Collectors.summingDouble(BigDecimal::doubleValue))));

        System.out.println(custOrdVal);

        //Filter orders based on date, and map customer to orders
        Map<String, Set<Order>> orderOnDate = orders.stream()
                .collect(Collectors.groupingBy(order -> order.getCustomer(),
                        Collectors.filtering(order -> order.getDate().equals(LocalDate.of(2018, 11, 22)),
                                Collectors.toSet())));

        Map<LocalDate, String> collect = orders.stream()
                .collect(Collectors.groupingBy(Order::getDate,
                        Collectors.mapping(Order::getCustomer,
                                Collectors.reducing("", (c1, c2) -> c2 + " " + c1))));


        System.out.println(collect);


    }

    public void test() {
        Food apple = new Food("Apple", BigDecimal.valueOf(1.99), LocalDate.of(2024, 12, 12));
        Drink coke = new Drink("Coke", BigDecimal.valueOf(2.99), LocalDate.of(2024, 12, 12));

        apple.setDiscount(BigDecimal.valueOf(0.10));
        coke.setDiscount(BigDecimal.valueOf(0.20));

        System.out.println("Coke discount :" + coke.getDiscount());
        System.out.println("Apple discount :" + apple.getDiscount());


    }
}
