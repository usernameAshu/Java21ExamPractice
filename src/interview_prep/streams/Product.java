package interview_prep.streams;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product implements Food {

    private String name;
    private BigDecimal price;
    private LocalDate bestBefore;
    private BigDecimal discount;

    public Product(String name, BigDecimal price, LocalDate bestBefore) {
        this.name = name;
        this.price = price;
        this.bestBefore = bestBefore;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }


    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", bestBefore=" + bestBefore +
                ", discount=" + discount +
                '}';
    }
}
