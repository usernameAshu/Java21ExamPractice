package interview_prep.threads;

public class SampleExample {

    public static void main(String[] args) {
        Producer p = new Producer();
        Consumer c = new Consumer();
        Runnable produce = () -> p.produce("Hello");
        Runnable consume = () -> c.consume();

        produce.run();
        consume.run();

    }

}

class Producer {

    void produce(String msg) {
        System.out.println("Produced...");
    }

}

class Consumer {
    void consume() {
        System.out.println("Consumed...");
    }

}
