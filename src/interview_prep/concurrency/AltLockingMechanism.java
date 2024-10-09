package interview_prep.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AltLockingMechanism {

    public static void main(String[] args) {

        List<Product> menu = new ArrayList<>();
        Product p1 = new Product();
        Product p2 = new Product();
        p1.setId(1);
        p1.setName("Burger");
        p2.setId(2);
        p2.setName("Wrap");

        PriceList priceList = new PriceList();



    }
}

class PriceList {
    List<Product> menu = new ArrayList<>();
    ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private Lock r1 = rw.readLock();
    private Lock w1 = rw.writeLock();

    public Optional<Product> get(int id) {
        r1.lock();
        try {
            return menu.stream().filter(p -> p.getId() == id).findFirst();
        } finally {
            r1.unlock();
        }
    }

    public boolean add(Product p) {
        w1.lock();
        try {
            return menu.add(p);
        } finally {
            w1.unlock();
        }
    }

    public List<Product> getAll() {
        try {
            if(!(r1.tryLock() || r1.tryLock(100, TimeUnit.MILLISECONDS))) {
                return null;
            }
        } catch (InterruptedException e) {}

        try {
            return Collections.unmodifiableList(menu);
        } finally {
            r1.unlock();
        }
    }

}
