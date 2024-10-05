package interview_prep.concurrency;

public class NotifyThread {
    public static void main(String[] args) {
        Task3 task = new Task3();
        Runnable r = () -> {
            String thread = Thread.currentThread().getName();
            task.perform();
            try {
                synchronized (task) {
                    System.out.println(thread + " is waiting...");
                    task.wait();
                }
            } catch (InterruptedException e) {
                System.out.println(thread + " is interrupted...");
            }
            System.out.println(thread + " is released...");
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
//        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
//        t3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {

        }

        //If we donot synchronize the same monitor which was used to block the thread to a waiting state,
        // then it will throw: IllegalMonitorStateException: current thread is not owner
        synchronized (task) {
            task.notifyAll();
        }
    }
}

class Task3 {
    public synchronized void perform() {
        String thread = Thread.currentThread().getName();
        System.out.println(thread + " has access to perform()...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }

    }
}
