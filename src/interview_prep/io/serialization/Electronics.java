package interview_prep.io.serialization;

import java.io.Serializable;

public class Electronics extends Product implements Serializable {
    private String name;
    private int price;

    public Electronics() {}

    public Electronics(String type, String name, int price) {
        super(type);
        this.name = name;
        this.price = price;
    }

    public Electronics(String name, int price) {
        this(name);
        this.price = price;
    }
    public Electronics(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                '}';
    }
}
