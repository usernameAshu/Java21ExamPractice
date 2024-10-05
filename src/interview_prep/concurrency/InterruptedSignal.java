package interview_prep.concurrency;

public class InterruptedSignal {

    public static void main(String[] args) {
        Task2 task = new Task2();
        Runnable r = task::perform;
        Thread t = new Thread(r);

        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.interrupt();
    }
}

class Task2 {

    public void perform() {
        Thread t = Thread.currentThread();

        while(!t.isInterrupted()) {
            System.out.println("Checking for interrupt...");
            //perform some task
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("Interrupt signal received...Exiting");
                //perform some task to be performed when interrupted
                return;
            }
        }
    }
}

