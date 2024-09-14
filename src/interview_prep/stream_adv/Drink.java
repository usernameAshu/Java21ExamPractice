package interview_prep.stream_adv;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Drink extends Product {

//    private String name;
//    private BigDecimal price;
//    private LocalDate bestBefore;
//    private BigDecimal discount;

    public Drink(String name, BigDecimal price, LocalDate bestBefore) {
        super(name, price, bestBefore);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", bestBefore=" + getBestBefore() +
                ", discount=" + getDiscount() +
                '}';
    }
}
