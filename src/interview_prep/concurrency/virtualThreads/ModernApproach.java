package interview_prep.concurrency.virtualThreads;

public class ModernApproach {
    public static void main(String[] args) {
        Task task = new Task();

        int MAX = 10;
        for (int i = 0; i < MAX; i++) {
            int index = i;

            Thread.startVirtualThread(() -> task.fetch(index));
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }

        System.out.println("Process finished " + Thread.currentThread().getName());
    }
}
/*
Here we can see that threads are not blocked by tasks,
whenever a task is waiting for some result, the thread yields to attend some other task.
This is very efficient use, since Java is not creating platform threads, but only virtual threads
 */
