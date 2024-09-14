package interview_prep.streams;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SoftDrink implements Drink{
    private String name;
    private BigDecimal price;
    private String brand;
    private BigDecimal discount;
    private boolean isSugarFree;
    private LocalDate bestBefore;

    public SoftDrink(String name, BigDecimal price, String brand, boolean isSugarFree, LocalDate bestBefore) {
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.isSugarFree = isSugarFree;
        this.bestBefore = bestBefore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public boolean isSugarFree() {
        return isSugarFree;
    }

    public void setSugarFree(boolean sugarFree) {
        isSugarFree = sugarFree;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    @Override
    public String toString() {
        return "SoftDrink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", discount=" + discount +
                ", isSugarFree=" + isSugarFree +
                ", bestBefore=" + bestBefore +
                '}';
    }
}
