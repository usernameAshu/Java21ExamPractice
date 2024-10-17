package designPatterns.creational;

import java.math.BigDecimal;

public class BuilderDesign {
    public static void main(String[] args) {
        Product product = new Product.Builder()
                .setId(1)
                .setName("Juice")
                .setPrice(BigDecimal.TEN)
                .build();

        Product p2 = new Product.Builder()
                .setId(2)
                .setName("Battery")
                .build();

        System.out.println(product);
        System.out.println(p2);
    }
}

/*
Create a Product class with private constructor, and a static Builder class,
which builds individual components of the Product class
 */
class Product {
    private int id;
    private String name;
    private BigDecimal price;

    private Product(int id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    static class Builder {
        private int id;
        private String name;
        private BigDecimal price;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this.id, this.name, this.price);
        }

    }

}
