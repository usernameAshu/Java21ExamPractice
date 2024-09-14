package interview_prep.stream_adv;

public class Customer {

    String name;

    public Customer(String jane) {
        this.name = jane;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
