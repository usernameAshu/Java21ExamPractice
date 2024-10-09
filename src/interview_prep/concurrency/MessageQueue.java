package interview_prep.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {
    private Queue<String> queue = new LinkedList<>();
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void write(String msg) {
        while (queue.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
            queue.add(msg);
            System.out.println("Message produced: " + msg);
            notifyAll();


    }

    public synchronized String read() {

        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        String msg = queue.poll();
        System.out.println("Message consumed " + msg);
        notifyAll();
        return msg;
    }


    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(5);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.write("Message " + i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    queue.read();
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                }
            }
        });

        producer.start();
        consumer.start();
    }
}
