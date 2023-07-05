package multithreading.advance.locks;

import java.util.concurrent.locks.ReentrantLock;

class MyBarrier implements Runnable{
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        for(int i =0;i<10;i++){
            System.out.println("ThreadName:"+Thread.currentThread().getName()+" Count:"+i);
        }
        lock.unlock();
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {

        MyBarrier r = new MyBarrier();
        Thread t1 = new Thread(r,"FirstThread");
        Thread t2 = new Thread(r,"SecondThread");
        t1.start();
        t2.start();
    }
}
