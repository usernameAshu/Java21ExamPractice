package interview_prep.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class NonBlockingActions {
    public static void main(String[] args) {
        Shared shared = new Shared();

        Runnable r = () -> {
            while(shared.x.get() < 10) {
                shared.x.incrementAndGet();
                System.out.println(Thread.currentThread().getName()+ " value: "+ shared.x.get());
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();t2.start();

    }
}

class Shared {
     AtomicInteger x = new AtomicInteger(0);
}
