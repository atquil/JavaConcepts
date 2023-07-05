package multithreading.basic;

class ThreadPrimary extends Thread{
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for(int i =0;i<4000; i++){
            System.out.println("Thread:"+threadName+" - "+i);
        }

    }
}

class ThreadSecondary extends Thread{
    @Override
    public void run() {
       String threadName = Thread.currentThread().getName();
        for(int i =0;i<4000; i++){
            System.out.println("Thread:"+threadName+" - "+i);
        }
    }
}

class DemonThread extends Thread{
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        for(int i =0;i<4000000; i++){
            System.out.println("Thread:"+threadName+" - "+i);
        }
    }
}

public class DemonTesting {
    public static void main(String[] args) {

        ThreadPrimary threadPrimary = new ThreadPrimary();
        threadPrimary.setName("Primary Thread");
        threadPrimary.setPriority(10);
        threadPrimary.start();

        DemonThread demonThread = new DemonThread();
        Thread thread = new Thread(demonThread,"Demon Thread");
        thread.setDaemon(true);
        thread.start();

        ThreadSecondary threadSecondary = new ThreadSecondary();
        threadSecondary.setName("Secondary Thread");
        threadSecondary.start();

    }
}
