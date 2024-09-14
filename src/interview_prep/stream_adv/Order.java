package interview_prep.stream_adv;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customer;
    private LocalDate date;
    private List<Product> items = new ArrayList<>();

    public Order(String customer, LocalDate date, List<Product> items) {
        this.customer = customer;
        this.date = date;
        this.items.addAll(items);
    }

    public String getCustomer() {
        return customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Product> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", date=" + date +
                ", items=" + items +
                '}';
    }
}
