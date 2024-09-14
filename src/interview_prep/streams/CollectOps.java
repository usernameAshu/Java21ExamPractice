package interview_prep.streams;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collect and reduce both work on a stream and produce a result. Collect is a mutable reduction operation.
 * It is more efficient than reduce because it uses a mutable container to accumulate the result.
 */
public class CollectOps {

    public static void main(String[] args) {
        List<Product> list = Utils.generateProductData();

        //summary values like average, min, max
        DoubleSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingDouble(p -> p.getPrice().doubleValue()));

        //mapping and joining
        String collect = list.stream()
                .collect(Collectors.mapping(p -> p.getName(), Collectors.joining(",")));

        System.out.println(stats);
        System.out.println(collect);

        //learn more about collect method
        //https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html

        //Perfrom conversion of Collector result by adding finisher function to the result of the collector
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
        String avgPrice = list.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.averagingDouble(p -> p.getPrice().doubleValue()),
                        n -> fmt.format(n)
                ));

        System.out.println(avgPrice);

        //Grouping and partitioning by
        Map<LocalDate, List<Product>> bestBeforeProds = list.stream()
                .collect(Collectors.groupingBy(p -> p.getBestBefore()));
        bestBeforeProds.forEach((k, v) -> System.out.println(k + "=" + v));

        Map<Boolean, List<Product>> expProds = list.stream()
                .collect(Collectors.partitioningBy(p -> p.getBestBefore().isBefore(LocalDate.now())));
        expProds.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
