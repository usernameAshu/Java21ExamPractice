package interview_prep.streams;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class AggregateOps {

    public static void main(String[] args) {

        String[] values = {"RED", "GREEN", "BLUE", "ORANGE", "WHITE", "BLACK"};
        long count = Arrays.stream(values).filter(s -> s.indexOf('R')!= -1).count();
        System.out.println(count);
        int sum = Arrays.stream(values).mapToInt(String::length).sum();
        System.out.println(sum);
        OptionalDouble avgOpt = Arrays.stream(values).mapToInt(String::length).average();
        double avg = avgOpt.isPresent() ? avgOpt.getAsDouble() : 0.0;
        System.out.println(BigDecimal.valueOf(avg).setScale(2, RoundingMode.HALF_UP));
        //max and min
        Optional<String> max = Arrays.stream(values).max((s1, s2) -> s1.compareTo(s2));
        String maxStr = max.isPresent() ? max.get() : "no data";
        System.out.println(maxStr);

    }
}
