package interview_prep.concurrency;

import interview_prep.dataStructures.leetcode.twoPointers.ThreeSum;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NonBlockingActions2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Runnable write = () -> {
            for (int i = 0; i < 10; i++) {
                synchronized (list) {
                    System.out.println(Thread.currentThread().getName() + " adding " + i + " to list");
                    list.add(i);
                }
            }
        };

        Runnable read = () -> {
            Iterator<Integer> it = list.iterator();
            synchronized (list) {
                while (it.hasNext()) {
                    System.out.println(Thread.currentThread().getName() + " reading " + it.next() + " from list");

                }
            }
        };


        for (int j = 0; j < 10; j++) {
            new Thread(write).start();
            //reading from the list while modifying causes ConcurrentModyificationException to occur
            //new Thread(read).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }

        System.out.println("Final list size: " + list.size());
    }
}
