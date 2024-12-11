package interview_prep.CollectionsFramework;

public class Product {
    String name;
    int price;

    Product() {
    }

    Product(String name) {
        this(name, 0);
    }

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        return price == product.price && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
