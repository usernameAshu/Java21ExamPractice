package interview_prep.streams;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static interview_prep.streams.Utils.generateProductData;

public class ProcessStreamPipelines {

    public static void main(String[] args) {

        List<Product> products = generateProductData();

        Predicate<Product> isExpire = p -> p.getBestBefore().isBefore(LocalDate.now());
        Consumer<Product> markDiscount = p -> p.setDiscount(BigDecimal.valueOf(0.10));
        Consumer<Product> applyDiscount = p -> {
            if (p.getDiscount() != null) {
                p.setPrice(p.getPrice().subtract(p.getPrice().multiply(p.getDiscount())));
            }

        };

        //orignal products
        //products.forEach(System.out::println);
//        System.out.println("----------After applying discount----------");
//        products.stream()
//                .filter(isExpire)
//                .peek(markDiscount)
//                .peek(applyDiscount)
//                .forEach(System.out::println);


        Map<LocalDate, List<Product>> collect = products.stream()
                .collect(Collectors.groupingBy(p -> p.getBestBefore()));
        //collect.entrySet().stream().forEach(System.out::println);

        Map<Boolean, List<Product>> expCollection = products.stream()
                .collect(Collectors.partitioningBy(p -> p.getBestBefore().isBefore(LocalDate.now())));

        expCollection.entrySet().stream().forEach(System.out::println);

    }


}
