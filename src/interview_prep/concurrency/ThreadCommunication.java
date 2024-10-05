package interview_prep.concurrency;

public class ThreadCommunication {

    static int balance = 0;

    synchronized void withdraw(int amount) {
        System.out.println("Withdrawing....");
        if (!(balance >= amount)) {
            try {
                wait(5000);
                if(balance >= amount ) {
                    balance -= amount;
                    System.out.println("Withdrawn="+amount+", Remaining="+balance);
                }
            } catch (InterruptedException e) {
                System.out.println("Timeout waiting for withdrawing");
            }
        }

    }

    synchronized void deposit(int amount) {
        System.out.println("Depositing....");
        balance += amount;
        System.out.println("Depositing="+amount+" New Balance="+ balance);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadCommunication comm = new ThreadCommunication();
        Runnable withdraw = () -> comm.withdraw(1000);
        Runnable deposit = () -> comm.deposit(2000);

        Thread w = new Thread(withdraw);
        Thread d = new Thread(deposit);

        w.start();
        Thread.sleep(5000);
        d.start();
    }
}
