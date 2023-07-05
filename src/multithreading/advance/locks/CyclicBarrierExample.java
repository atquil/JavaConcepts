package multithreading.advance.locks;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MyRunnables implements Runnable {
    private final CyclicBarrier barrier;

    public MyRunnables(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    public void run() {
        try {
            // Perform some task
            System.out.println("Task performed by thread " + Thread.currentThread().getName());

            // Wait for all threads to reach the barrier
            barrier.await();

            // Perform some other task
            System.out.println("Other task performed by thread " + Thread.currentThread().getName());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
    public class CyclicBarrierExample {
        public static void main (String[]args){
            int numThreads = 3;
            // When all thread, reaches to barrier, a Runnable object, will be triggered to print this statement. 
            CyclicBarrier barrier = new CyclicBarrier(numThreads, () -> System.out.println("All threads have reached the barrier"));

            for (int i = 0; i < numThreads; i++) {
                MyRunnables r = new MyRunnables(barrier);
                Thread t = new Thread(r);
                t.start();
            }
        }
    }

