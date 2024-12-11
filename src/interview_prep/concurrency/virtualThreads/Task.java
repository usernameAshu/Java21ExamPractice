package interview_prep.concurrency.virtualThreads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task {

    /* this can be any I/O task like fetching from
    database, rest api, or reading any file system
     */
    public void fetch(int index) {
        try {
            var length = Files.lines(Paths.get("Message.txt")).count();
            System.out.println("Starting " + index + " " + Thread.currentThread() + " length: " + length);
            Thread.sleep(2000);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finishing " + index + " " + Thread.currentThread());
    }
}
/*
Individual tasks are taken up by individual threads,
so when the specific task takes more time to finish,
then that specific thread is also blocked for that period of time.

Now things get messy when you have Thousands of threads, then you block thousands of threads
This will eat up resource and will give an error: Resource limit exceeded

To, solve this problem we have the virtual threads concept.
 */