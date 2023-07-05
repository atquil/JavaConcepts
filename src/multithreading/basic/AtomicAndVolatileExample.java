package multithreading.basic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicAndVolatileExample {
    private static AtomicInteger counter = new AtomicInteger(0);
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (!flag) {
                counter.incrementAndGet();
            }
            System.out.println("Thread 1 finished. Counter value: " + counter.get());
        });

        Thread t2 = new Thread(() -> {
            flag = true;
            System.out.println("Thread 2 finished. Flag value: " + flag);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
