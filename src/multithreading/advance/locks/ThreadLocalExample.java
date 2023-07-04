package multithreading.advance.locks;

import java.util.concurrent.CountDownLatch;

public class ThreadLocalExample {

    static String withoutThreadLocal = "Initial";
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Initial Thread");
        System.out.println("Main thread:"+Thread.currentThread().getName()+"Has value:"+threadLocal.get());

        Thread t1 = new Thread(() -> {
            System.out.println("T1 initial value:"+threadLocal.get());
            threadLocal.set("Thread 1");
            System.out.println("T1  After:"+threadLocal.get());
            countDownLatch.countDown();
        });

        Thread t2 = new Thread(() -> {
            System.out.println("T2 initial:"+threadLocal.get());
            threadLocal.set("Thread 2");
            System.out.println("T2 After:"+threadLocal.get());
            countDownLatch.countDown();
        });
        Thread t3 = new Thread(()->{
            System.out.println("Before:"+withoutThreadLocal);
            withoutThreadLocal = "Beta";
            System.out.println("After:"+withoutThreadLocal);
        });
        Thread t4 = new Thread(()->{
            System.out.println("Before:"+withoutThreadLocal);
            withoutThreadLocal = "Gama";
            System.out.println("After:"+withoutThreadLocal);
        });


        t1.start();
        t2.start();
        countDownLatch.await();

        System.out.println("------------------");
        t3.start();
        t4.start();
    }
}
