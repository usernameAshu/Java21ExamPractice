package interview_prep.virtualThreads;

public class TraditionalApproach {

    public static void main(String[] args) {
        int MAX = 10;
        Task task = new Task();
        for (int i = 0; i < MAX; i++) {
            int index = i;
            new Thread(() -> task.fetch(index)).start();
        }

        try{
            Thread.sleep(5000);
        } catch (InterruptedException ex) {}

        System.out.println("Process finished "+ Thread.currentThread().getName());
    }
}

