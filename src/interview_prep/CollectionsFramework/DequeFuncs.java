package interview_prep.CollectionsFramework;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeFuncs {
    public static void main(String[] args) {
        /*
         Data structures implement LIFO and FIFO concepts
         Double ended queues (deque)
         Cannot store Null values
         */
        Deque<Product> deque = new ArrayDeque<>();
        Product p1 = new Product("Tea");
        Product p2 = new Product("cake");
        Product p3 = new Product("samosa");

        deque.offerFirst(p1);
        deque.offerLast(p2);
        deque.offerFirst(p3);

        System.out.println(deque);

        deque.pollFirst();
    }
}
