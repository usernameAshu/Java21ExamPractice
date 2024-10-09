package interview_prep.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NonBlockingActions3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> sList = Collections.synchronizedList(list);

        Runnable write = () -> {
            String name = Thread.currentThread().getName();
            for(int i=0;i<10; i++) {
                sList.add("name "+ i);
            }
        };

        Thread[] threads = new Thread[10];
        for(int i=0; i< threads.length; i++) {
            threads[i] = new Thread(write);
            threads[i].start();
        }

        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {

            }
        }

        synchronized (sList) {
            Iterator<String> i = sList.iterator();
            while(i.hasNext()) {
                System.out.println(i.next());
            }
        }
    }
}
