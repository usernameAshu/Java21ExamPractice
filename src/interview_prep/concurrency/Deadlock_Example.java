package interview_prep.concurrency;

import java.io.IOException;

public class Deadlock_Example {
    public static String s1 = "first_lock";
    public static String s2 = "second_lock";

    public static void main(String[] args) {
        Runnable r1 = () ->{
            synchronized (s1) {
                String thread = Thread.currentThread().getName();
                System.out.println("Acquired lock on s1 by "+ thread);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                System.out.println("Waiting for lock on s2 by "+ thread);
                synchronized (s2) {
                    System.out.println("Acquired lock on s2 by "+ thread);
                }
            }
        };

        Runnable r2 = () -> {
            synchronized (s2) {
                String thread = Thread.currentThread().getName();
                System.out.println("Acquired lock on s2 by "+ thread);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                System.out.println("Waiting for lock on s1 by "+ thread);
                synchronized (s1) {
                    System.out.println("Acquired lock on s1 by "+ thread);
                }
            }
        };

        Thread t1 = new Thread(r1, "first");
        Thread t2 = new Thread(r2, "second");
        t1.start();
        t2.start();
    }
}
