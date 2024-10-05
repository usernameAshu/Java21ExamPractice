package interview_prep.concurrency;

/**
 * Instances of class (objects) act a monitor which Blocks thread in case of synchronized scenarios
 * In case of blocking the monitor object only allows 1 thread to access the block of code at a time.
 * So, if you have group of Runnables, pointing to the same object, then those threads will gate at the gate
 * But, in case you have created Different objects of the Class, and you have each Runnables assigned to each object,
 * then, threads
 */
public class BlockingExample {

    public static void main(String[] args) {
        Some s1 = new Some();
        Runnable r1 = () -> {
          s1.a();
          Some.b();
          synchronized (s1) {
              s1.c();
          }
        };

        Some s2 = new Some();
        Runnable r2 = () -> {
            s2.a();
            Some.b();
            synchronized (s2) {
                s2.c();
            }
        };


        Thread t1 = new Thread(r1,"Thread-1");
        Thread t2 = new Thread(r2,"Thread-2");

        t1.start();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//        }
        t2.start();
    }
}


class Some {
    public synchronized void  a() {
        output(" has access to a()");
    }

    public synchronized static void b() {
        String thread = Thread.currentThread().getName();
        System.out.println(thread + " has access to b()");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(thread + " has been interrupted");
        }
    }

    public void c() {
        output(" has access to c()");
    }

    private void output(String x) {
        String thread = Thread.currentThread().getName();
        System.out.println(thread + x);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(thread + " has been interrupted");
        }
    }
}
