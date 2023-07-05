package multithreading.advance.locks;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(3);

        Thread t1 = new Thread(new Task(latch), "Thread 1");
        Thread t2 = new Thread(new Task(latch), "Thread 2");
        Thread t3 = new Thread(new Task(latch), "Thread 3");

        t1.start();
        t2.start();
        t3.start();

        try {
            latch.await(); // Once the countDown reaches to 0 then only it will move ahead.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished executing.");
    }
}

class Task implements Runnable {
    private final CountDownLatch latch;

    public Task(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started executing.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished executing.");

        latch.countDown();
        System.out.println(latch.getCount());
    }
}
