package interview_prep.concurrency;

public class JoinExample {

    public static void main(String[] args) {

        Runnable r1 = () -> {
            String thread = Thread.currentThread().getName();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
            System.out.println(thread+" is completed");
        };
        Runnable r2 = () -> {
            String thread = Thread.currentThread().getName();
            try {
                Thread.sleep(8000);
            } catch (InterruptedException ex) {}
            System.out.println(thread+" is completed");
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        try {
            //other threads wait for t2 to finish
            t2.join();
        } catch (InterruptedException e) {

        }

        System.out.println(Thread.currentThread().getName()+ " End program");
    }
}


