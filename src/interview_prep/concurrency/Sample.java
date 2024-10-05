package interview_prep.concurrency;

public class Sample {
    public static void main(String[] args) {
        Task task = new Task();
        Runnable work = task::perform;

        System.out.println("Main thread...start");
        Thread t = new Thread(work);
        t.start();
        System.out.println("Main thread...stop");
    }
}

class Task {
    public void perform() {
        System.out.println("Performing...");
        try{
            Thread.sleep(1500);
        } catch (InterruptedException e) {}
        System.out.println("Completed...");
    }
}
