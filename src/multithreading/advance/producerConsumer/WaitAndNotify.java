package multithreading.advance.producerConsumer;

// Producer -- > Utility --> Consumer

import javax.swing.*;

class Utility{
    String inside;
    boolean isReading = false;
    synchronized void set(String inside) throws InterruptedException {
        while(isReading){
            wait();
        }
        this.inside = inside;
        isReading = true;
        System.out.println("Done writing"+inside);
        notify();
    }
    synchronized void get() throws InterruptedException {
        while (!isReading){
            wait();
        }
        System.out.println("Done reading: "+inside);
        isReading = false;
        notify();
    }
}


class Produce implements Runnable{
    private final Utility utility;

    Produce(Utility utility) {
        this.utility = utility;
        Thread producer = new Thread(this,"Producer");
        producer.start();
    }

    @Override
    public void run() {
       String name = "alpha" ;
        while(true){
            try {
                utility.set(name);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
class Consumer implements Runnable{
    private final Utility utility;

    Consumer(Utility utility) {
        this.utility = utility;
        Thread consumer = new Thread(this,"Consumer");
        consumer.start();
    }

    @Override
    public void run() {
        while(true){
            try {
                utility.get();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class WaitAndNotify {
    public static void main(String[] args) {
        Utility utility = new Utility();
        new Produce(utility);
        new Consumer(utility);
    }
}
