package streams;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BiOperators {
    static System.Logger logger = System.getLogger("BiOperators");
    public static void main(String[] args) {
        Food drink = new Drink("Coke", new BigDecimal("5"));
        Food snack = new Snack("Chips", new BigDecimal("10"));

        Map<Food, Integer> orders = new HashMap<>();
        orders.put(drink, 2);
        orders.put(snack, 3);

        //calculate the total cost of the order
        BigDecimal total = orders.entrySet().stream()
                .map(entry -> entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        logger.log(System.Logger.Level.INFO, "Total cost: $" + total);

    }
}

class Food {
    private final String name;
    private final BigDecimal price;

    public Food(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Drink extends Food {

    public Drink(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}

class Snack extends Food {

    public Snack(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Snack{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}

