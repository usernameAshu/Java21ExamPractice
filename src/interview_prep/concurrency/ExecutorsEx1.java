package interview_prep.concurrency;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorsEx1 {
    public static void main(String[] args) {

        runnableExample();
        //callableExample();


    }

    private static void runnableExample() {
        //ExecutorService lifecycle
        Runnable run = () -> {
            //perform some task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
            System.out.println("Task done...");
        };

        ExecutorService es = Executors.newFixedThreadPool(2); /* create a pool of 2 threads */
        //es.execute(run);

        /* launch 10 runnable tasks with 2 running tasks at any time */
        for(int i =0; i<10; i++) {
            es.execute(run);
        }

        es.shutdown(); /* stop accepting new tasks */
        try {
            if(es.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("All tasks are completed");
            } else {
                /* If timeout exceeded , and tasks are still not terminated */
                System.out.println("Tasks not completed..");
                List<Runnable> runnables = es.shutdownNow();
                System.out.println("No of incomplete tasks: "+runnables.size());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void callableExample() {
        Callable<String> call = () -> {
            //perform some task
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {}
            return "Success";
        };

        ExecutorService task = Executors.newFixedThreadPool(2);
        Future<String> response = task.submit(call);

        //perform some other task
        try {
            String value = response.get(10, TimeUnit.SECONDS);
            System.out.println(value);
        } catch (Exception e) {
            //timeout/Interrupt/Runtime exception happened
        } finally {
            task.shutdown();
        }
    }
}
